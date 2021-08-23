package Test;

import edu.princeton.cs.algs4.Stack;

import java.io.*;
import java.util.Scanner;

public class Analize {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (true) {
            s = scanner.nextLine();
            try {
                System.out.println(new Analize().get(s, 0));
            } catch (Exception e) {
                System.out.println("@column中函数不符合规则，请检查是否正确，减少不必要的空格");
                e.printStackTrace();
            }

        }
        //  System.out.println(new analize().getnext(4,s));
    }
    String quote = "`";
    public String get(String expression, int depth) throws Exception {
        // raw
        if ("".equals(Functions.RAW_MAP.get(expression))) return expression;
        Stack<String> stack = new Stack<>();
        int len = expression.length();
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < expression.length()) {
            char c = expression.charAt(i);
            //一段一段解析  是遇见非 ' ' ,几种情况： 1、字段 2. 字符串  3. 是函数  。情况1 ，2 直接截取，情况3 ，判断最外层函数的括号位置，递归的解析括号内部的函数。
            if (c != ' ') {
                //是冒号
                if (c == ',') {
                    res.append(',');
                    i++;
                } else {
                    //是字符
                    StringBuilder stringBuilder = new StringBuilder();
                    int j = i;
                    //是字符串开始
                    if (c == '\'') {
                        j = i + 1;
                        while (j < len && expression.charAt(j) != '\'') {
                            stringBuilder.append(expression.charAt(j));
                            j++;
                        }
                        res.append(expression.substring(i, j + 1));
                        i = j + 1;
                    } else {
                        //不是字符串开始
                        //不是 1：函数 2:字段
                        //思路一
                        int endfun = -1;
                        int right = 0;
                        //  moment : m ,comment : c
                        while (j < len && expression.charAt(j) != ' ' && expression.charAt(j) != ',' && expression.charAt(j) != ':') {
                            //是函数
                            if (expression.charAt(j) == '(') {
                                String fun = stringBuilder.toString();
                                //判断fun
                                if (fun.isEmpty() == false) {
                                    if (Functions.SQL_FUNCTION_MAP == null || Functions.SQL_FUNCTION_MAP.isEmpty()) {
                                        if (StringUtil.isName(fun) == false) {
                                            throw new IllegalArgumentException("字符 " + fun + " 不合法！"
                                                    + "预编译模式下 @column:\"column0,column1:alias;function0(arg0,arg1,...);function1(...):alias...\""
                                                    + " 中 function 必须符合小写英文单词的 SQL 函数名格式！");
                                        }
                                    } else if (Functions.SQL_FUNCTION_MAP.containsKey(fun) == false) {
                                        throw new IllegalArgumentException("字符 " + fun + " 不合法！"
                                                + "预编译模式下 @column:\"column0,column1:alias;function0(arg0,arg1,...);function1(...):alias...\""
                                                + " 中 function 必须符合小写英文单词的 SQL 函数名格式！且必须是后端允许调用的 SQL 函数!");
                                    }
                                }
                                // 思路1 寻找结尾 空格 （错误）
                                //思路2 根据括号寻找
                                right = getnext(j + 1, expression);
                                if (right == -1) {
                                    throw new RuntimeException("函数括号不匹配");
                                } else {

                                    stringBuilder.append("(");
                                    // 递归调用
                                    stringBuilder.append(get(expression.substring(j + 1, right), depth + 1));
                                    stringBuilder.append(")");
                                    endfun = 1;
                                }
                                break;
                            } else {
                                stringBuilder.append(expression.charAt(j));
                                j++;
                            }
                        }
                        // j ： 循环结束的下标 可能是（结尾/遇见空格/遇见”：“）  right： 函数结束的下标
                        if (j == len) endfun = 4;
                        else if (expression.charAt(j) == ' ') {
                            endfun = 3;
                        } else if (expression.charAt(j) == ',') {
                            endfun = 2;
                        }
                        //  1 ，解析函数结束 2.遇见“，结束  3. 遇见空格结束 4. 到了结尾结束. -1: 字段遇见”：“结束
                        if (endfun == 1) {
                            if ((right + 1) < len && expression.charAt(right + 1) == ':') {
                                // 获取别名的结束下标 可能是s的结尾或者是遇见空格冒号
                                int k = StringUtil.getAlians(right + 1, expression);
                                // 获取别名 并加上 quote
                                String alians = StringUtil.getQuoteColumn(expression.substring(right + 2, k), quote);
                                res.append(stringBuilder.append(" AS ").append(alians));
                                i = k;
                            } else {
                                res.append(stringBuilder);
                                i = right + 1;
                            }
                        } else if (endfun == 2 || endfun == 3) {
                            //字段在 rawmap中
                            if ("".equals(Functions.RAW_MAP.get(stringBuilder.toString()))) {
                                res.append(stringBuilder.toString());
                                i = j;
                            } else {
                                // 判断是否是数字
                                if (StringUtil.isNumer(stringBuilder.toString())) {
                                    res.append(stringBuilder.toString());
                                } else {
                                    res.append(StringUtil.getQuoteColumn(stringBuilder.toString(), quote));
                                }
                                i = j;
                            }
                            //}
                        } else if (endfun == 4) {
                            // 到了 字符串的结尾
                            // 如果早RAW_MAP中
                            if ("".equals(Functions.RAW_MAP.get(stringBuilder.toString()))) {
                                res.append(stringBuilder.toString());
                            }else {
                                //如果是数字
                                if (StringUtil.isNumer(stringBuilder.toString())) {
                                      res.append(stringBuilder);
                                } else {
                                 stringBuilder.insert(0, quote);
                                 stringBuilder.append(quote);
                                 res.append(stringBuilder);
                              }
                            }
                            i = j;
                        } else if (endfun == -1) {
                            //
                            if (expression.charAt(j) == ':') {
                                int k = StringUtil.getAlians(j + 1, expression);
                                String alians = StringUtil.getQuoteColumn(expression.substring(j + 1, k), quote);
                                stringBuilder.insert(0, quote);
                                stringBuilder.append(quote);
                                res.append(stringBuilder.append(" AS ").append(alians));
                                i = k;
                            } else {
                                stringBuilder.insert(0, quote);
                                stringBuilder.append(quote);
                                res.append(stringBuilder);
                                i = j;
                            }
                        }
                    }
                }
            } else {
                int j = i;
                while (j < len && expression.charAt(j) == ' ') j++;
                //空格浓缩
                if (j < len) res.append(' ');
                i = j;
            }
        }
        return res.toString();
    }

    private int getnext(int j, String s) {
        Stack<Integer> stack = new Stack<>();
        int index = j;
        boolean isString = false;
        while (index < s.length()) {
            if (s.charAt(index) == '\'') {
                isString = !isString;
            } else if (s.charAt(index) == '(' && !isString) {
                stack.push(index);
            } else if (s.charAt(index) == ')' && !isString) {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    return index;
                }
            }
            index++;
        }
        return -1;
    }

}
