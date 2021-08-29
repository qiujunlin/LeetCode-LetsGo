package Test.FuncionAnalize;

import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ColumnPrase {
    // 多了一个解析字符串 解析
    public static void main(String[] args) {
        String s = "cast(now() as date)";
        Scanner scanner = new Scanner(System.in);
        ColumnPrase columnPrase = new ColumnPrase();
        while (true) {
            s = scanner.nextLine();
            try {
                System.out.println(columnPrase.getColumnPrase(s));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    private boolean keyPrefix = false;
    private boolean prepared = false;
    String tableAlias = null;

    public boolean isKeyPrefix() {
        return keyPrefix;
    }

    public boolean isPrepared() {
        return prepared;
    }

    String quote = "`";

    /**
     * 解析@column 中以“;”分隔的表达式（"@column":"expression1;expression2;expression2;...."）中的expression
     *
     * @param expression
     * @return
     */
    public String getColumnPrase(String expression) {
        // raw

        if ("".equals(Functions.RAW_MAP.get(expression))) return expression;

        int start = expression.indexOf('(');
        if (start < 0) {
            //没有函数   可能是字段  也可能是 DISTINCT 交给 函数解析
            String cks[] = parseArgsSplitWithComma(expression, true);
            expression = StringUtil.getString(cks);
        } else {
            // 有函数
            //不是窗口函数
            if (expression.indexOf("OVER") < 0 || expression.indexOf("over") < 0) {
                int end = expression.lastIndexOf(")");
                if (start >= end) {
                    throw new IllegalArgumentException("字符 " + expression + " 不合法！"
                            + "@column:value 中 value 里的 SQL函数必须为 function(arg0,arg1,...) 这种格式！");
                }

                String fun = expression.substring(0, start);
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

                // 以 ”,“ 分割函数 所有参数
                String s = expression.substring(start + 1, end);
                // 解析函数内的参数
                String ckeys[] = parseArgsSplitWithComma(s, false);

                String suffix = expression.substring(end + 1, expression.length()); //:contactCount
                int index = suffix.lastIndexOf(":");
                String alias = index < 0 ? "" : suffix.substring(index + 1); //contactCount
                suffix = index < 0 ? suffix : suffix.substring(0, index);
                if (alias.isEmpty() == false && StringUtil.isName(alias) == false) {
                    throw new IllegalArgumentException("字符串 " + alias + " 不合法！"
                            + "预编译模式下 @column:value 中 value里面用 ; 分割的每一项"
                            + " function(arg0,arg1,...):alias 中 alias 必须是1个单词！并且不要有多余的空格！");
                }


                if (suffix.isEmpty() == false && (((String) suffix).contains("--") || ((String) suffix).contains("/*") || Functions.PATTERN_RANGE.matcher((String) suffix).matches() == false)) {
                    throw new UnsupportedOperationException("字符串 " + suffix + " 不合法！"
                            + "预编译模式下 @column:\"column?value;function(arg0,arg1,...)?value...\""
                            + " 中 ?value 必须符合正则表达式 " + Functions.PATTERN_RANGE + " 且不包含连续减号 -- 或注释符 /* ！不允许多余的空格！");
                }

                String origin = fun + "(" + StringUtil.getString(ckeys) + ")" + suffix;
                expression = origin + (StringUtil.isEmpty(alias, true) ? "" : " AS " + quote + alias + quote);

            } else {
                //是窗口函数   fun(arg0,agr1) OVER (agr0 agr1 ...)
                //String  res  = "";
                int overindex = expression.indexOf("OVER"); // over  的位置
                String s1 = expression.substring(0, overindex); // over 前半部分
                String s2 = expression.substring(overindex); // 后半部分
                int index1 = s1.indexOf("("); //  函数 "(" 的起始位置
                String fun = s1.substring(0, index1); // 函数名称

                if (!"".equals(Functions.SQL_FUNCTION_MAP.get(fun))) {
                    throw new IllegalArgumentException("字符 " + fun + " 不合法！"
                            + "预编译模式下 @column:\"column0,column1:alias;function0(arg0,arg1,...);function1(...):alias...\""
                            + " 中 function 必须符合小写英文单词的 SQL 函数名格式！且必须是后端允许调用的 SQL 函数!");
                }

                // 获取前半部分函数的参数解析   fun(arg0,agr1)

                String agrsString1[] = parseArgsSplitWithComma(s1.substring(index1 + 1, s1.lastIndexOf(")")), false);
                int index2 = s2.indexOf("("); // 后半部分 “(”的起始位置
                int end = s2.lastIndexOf(")"); // 后半部分 “)” 的位置
                String argString2 = s2.substring(index2 + 1, end); // 后半部分的参数

                // 别名
                String alias = s2.lastIndexOf(":") < 0 ? null : s2.substring(s2.lastIndexOf(":") + 1);

                String mkes[] = StringUtil.split(argString2, " ", true);

                // 获取后半部分的参数解析 (agr0 agr1 ...)
                String argString = praseArgsSplitWithSpace(mkes);
                expression = fun + "(" + StringUtil.getString(agrsString1) + ")" + " OVER " + "(" + argString + ")" + (StringUtil.isEmpty(alias, true) ? "" : " AS " + quote + alias + quote);
            }
        }
        return expression;

    }

    /**
     * 用来解析参数   可以是函数里的参数,可以是字段
     *
     * @param param
     * @param isColumn
     * @return
     */
    private String[] parseArgsSplitWithComma(String param, boolean isColumn) {
        // 以"," 分割参数
        String ckeys[] = StringUtil.split(param);
        if (ckeys != null && ckeys.length > 0) {
            String origin;
            String alias;
            int index;
            for (int i = 0; i < ckeys.length; i++) {
                // 如果参数包含 "'"
                if (ckeys[i].contains("'")) {
                    // 解析字符串的参数
                    int count = 0;
                    for (int j = 0; j < ckeys[i].length(); j++) {
                        if (ckeys[i].charAt(j) == '\'') count++;
                    }
                    // 排除了参数中包含 ' 的情况，同时排除 cast('s' as ...) 以空格分隔的参数中包含字符串的情况
                    if (count != 2 || !(ckeys[i].startsWith("'") && ckeys[i].endsWith("'"))) {
                        throw new IllegalArgumentException("字符串 " + ckeys[i] + " 不合法！"
                                + "预编译模式下 @column:\"column0,column1:alias;function0(arg0,arg1,...);function1(...):alias...\""
                                + " 中字符串参数不合法，必须以'开头,'结尾,字符串中不能包含' ");
                    }
                    //sql 注入判断 判断
                    origin = (ckeys[i].substring(1, ckeys[i].length() - 1));
                    if (origin.contains("--") || Functions.PATTERN_STRING.matcher(origin).matches() == true) {
                        throw new IllegalArgumentException("字符 " + ckeys[i] + " 不合法！"
                                + "预编译模式下 @column:\"column0,column1:alias;function0(arg0,arg1,...);function1(...):alias...\""
                                + " 中所有字符串 arg 都必须不符合正则表达式 " + Functions.PATTERN_STRING + " 且不包含连续减号 -- ！");
                    }

                    // 字符串 不是字段 也没有别名
                    ckeys[i] = getValue(ckeys[i].substring(1, ckeys[i].length() - 1)).toString();


                } else {

                    // 参数不包含","
                    // 解析函数参数:1.字段 ，2 .是以空格分隔的参数eg: cast(now() as date)

                    index = ckeys[i].lastIndexOf(":"); //StringUtil.split返回数组中，子项不会有null
                    origin = index < 0 ? ckeys[i] : ckeys[i].substring(0, index); //获取 ：之前的
                    alias = index < 0 ? null : ckeys[i].substring(index + 1);
                    if (isPrepared()) {
                        if (isColumn) {
                            if (StringUtil.isName(origin) == false || (alias != null && StringUtil.isName(alias) == false)) {
                                throw new IllegalArgumentException("字符 " + ckeys[i] + " 不合法！"
                                        + "预编译模式下 @column:value 中 value里面用 , 分割的每一项"
                                        + " column:alias 中 column 必须是1个单词！如果有alias，则alias也必须为1个单词！"
                                        + "DISTINCT 必须全大写，且后面必须有且只有 1 个空格！其它情况不允许空格！");
                            }
                        } else {
                            if (origin.startsWith("_") || origin.contains("--") || Functions.PATTERN_FUNCTION.matcher(origin).matches() == false) {
                                throw new IllegalArgumentException("字符 " + ckeys[i] + " 不合法！"
                                        + "预编译模式下 @column:\"column0,column1:alias;function0(arg0,arg1,...);function1(...):alias...\""
                                        + " 中所有 arg 都必须是1个不以 _ 开头的单词 或者符合正则表达式 " + Functions.PATTERN_FUNCTION + " 且不包含连续减号 -- ！DISTINCT 必须全大写，且后面必须有且只有 1 个空格！其它情况不允许空格！");
                            }
                        }
                    }

                    String mkes[] = StringUtil.split(ckeys[i], " ", true);

                    boolean isName = false;
                    //如果参数中含有空格(极少数情况) 比如  fun(arg1 arg2 arg3 ,arg4) ，比如 DISTINCT id 直接解析
                    if (mkes != null && mkes.length >= 2) {
                        ckeys[i] = praseArgsSplitWithSpace(mkes);
                    } else {
                        // 如果参数没有空格
                        if ("".equals(Functions.RAW_MAP.get(origin))) {
                            // do nothing  解析特殊情况 比如 toDate(now())
                        } else if (StringUtil.isNumer(origin)) {
                            //do nothing
                        } else if (StringUtil.isName(origin)) {
                            origin = quote + origin + quote;
                            isName = true;
                        } else {
                            origin = getValue(origin).toString();
                        }
                        if (isName && isKeyPrefix()) {
                            ckeys[i] = tableAlias + "." + origin;
                            if (StringUtil.isEmpty(alias, true) == false) {
                                ckeys[i] += " AS " + quote + alias + quote;
                            }
                        } else {
                            ckeys[i] = origin + (StringUtil.isEmpty(alias, true) ? "" : " AS " + quote + alias + quote);
                        }
                    }

                }
            }
        }
        return ckeys;
    }


    /**
     * 解析 以空格分隔的参数
     * @param mkes
     * @return
     */
    private String praseArgsSplitWithSpace(String mkes[]) {
        boolean isName = false;
        String origin;
        // 包含空格的参数  肯定不包含别名 不用处理别名
        if (mkes != null && mkes.length > 0) {
            for (int j = 0; j < mkes.length; j++) {
                origin = mkes[j];
                //  now() / as/ distinct/value 等等放在RAW_MAP中
                if ("".equals(Functions.RAW_MAP.get(mkes[j]))) {
                    continue;
                } else if (StringUtil.isNumer(mkes[j])) {
                    // do nothing
                } else {
                    if (StringUtil.isName(origin) == false) {
                        throw new IllegalArgumentException("字符 " + origin + " 不合法！"
                                + "预编译模式下 @column:value 中 value里面用 , 分割的每一项"
                                + " column:alias 中 column 必须是1个单词！如果有alias，则alias也必须为1个单词！"
                                + "DISTINCT 必须全大写，且后面必须有且只有 1 个空格！其它情况不允许空格！");
                    }
                    mkes[j] = quote + mkes[j] + quote;
                    isName = true;
                }
                if (isName && isKeyPrefix()) {
                    mkes[j] = tableAlias + "." + mkes[j];
                }
            }
        }
        return StringUtil.join(mkes, " ");
    }

    private List<Object> preparedValueList = new ArrayList<>();

    private Object getValue(Object value) {
        if (isPrepared()) {
            preparedValueList.add(value);
            return "?";
        }
        return getSQLValue(value);
    }

    public Object getSQLValue(Object value) {
        //return  value;
        //		return (value instanceof Number || value instanceof Boolean) && DATABASE_POSTGRESQL.equals(getDatabase()) ? value :  "'" + value + "'";
        return (value instanceof Number || value instanceof Boolean) ? value : "'" + value + "'"; //MySQL 隐式转换用不了索引
    }


}
