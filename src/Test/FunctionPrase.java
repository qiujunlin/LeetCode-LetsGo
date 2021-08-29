package Test;

import Test.FuncionAnalize.Functions;
import Test.FuncionAnalize.StringUtil;

import java.util.*;
import java.util.regex.Pattern;

public class FunctionPrase {
    // * 和 / 不能同时出现，防止 /* */ 段注释！ # 和 -- 不能出现，防止行注释！ ; 不能出现，防止隔断SQL语句！空格不能出现，防止 CRUD,DROP,SHOW TABLES等语句！
    private static final Pattern PATTERN_RANGE;
    private static final Pattern PATTERN_FUNCTION;
    public static String PREFFIX_DISTINCT = "DISTINCT ";
    public static final Map<String, String> RAW_MAP;
    static {
        PATTERN_RANGE = Pattern.compile("^[0-9%,!=\\<\\>/\\.\\+\\-\\*\\^]+$"); // ^[a-zA-Z0-9_*%!=<>(),"]+$ 导致 exists(select*from(Comment)) 通过！
        PATTERN_FUNCTION = Pattern.compile("^[A-Za-z0-9%,:_@&~!=\\<\\>\\|\\[\\]\\{\\} /\\.\\+\\-\\*\\^\\?\\$]+$"); //TODO 改成更好的正则，校验前面为单词，中间为操作符，后面为值

        RAW_MAP = new LinkedHashMap<>();  // 保证顺序，避免配置冲突等意外情况

        RAW_MAP.put("cast(now() as date)","");
        RAW_MAP.put("sum(if(userId%2=0,1,0))","");
        RAW_MAP.put("to_days(now())-to_days(`date`)<=7","");
    }
    public String getColumnString()  {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> column = new ArrayList<>(Arrays.asList(s.split(";")));
        String tableAlias = "Comment";


        String[] keys = column == null ? null : column.toArray(new String[]{}); //StringUtil.split(c, ";");


        String expression;
        String method = null;

        //...;fun0(arg0,arg1,...):fun0;fun1(arg0,arg1,...):fun1;...
        for (int i = 0; i < keys.length; i++) {
            //fun(arg0,arg1,...)
            expression = keys[i];
            // 由于 HashMap 对 key 做了 hash 处理，所以 get 比 containsValue 更快
                if ("".equals(RAW_MAP.get(expression)) || RAW_MAP.containsValue(expression)) {  // newSQLConfig 提前处理好的
                    continue;
            }

            if (expression.length() > 50) {
                throw new UnsupportedOperationException("@column:value 的 value 中字符串 " + expression + " 不合法！"
                        + "不允许传超过 50 个字符的函数或表达式！请用 @raw 简化传参！");
            }


            int start = expression.indexOf("(");
            int end = 0;
            if (start >= 0) {
                end = expression.lastIndexOf(")");
                if (start >= end) {
                    throw new IllegalArgumentException("字符 " + expression + " 不合法！"
                            + "@column:value 中 value 里的 SQL函数必须为 function(arg0,arg1,...) 这种格式！");
                }

                method = expression.substring(0, start);
                boolean distinct = i <= 0 && method.startsWith(PREFFIX_DISTINCT);
                String fun = distinct ? method.substring(PREFFIX_DISTINCT.length()) : method;

                if (fun.isEmpty() == false) {
                    if (Functions.SQL_FUNCTION_MAP == null || Functions.SQL_FUNCTION_MAP.isEmpty()) {
                        if (StringUtil.isName(fun) == false) {
                            throw new IllegalArgumentException("字符 " + method + " 不合法！"
                                    + "预编译模式下 @column:\"column0,column1:alias;function0(arg0,arg1,...);function1(...):alias...\""
                                    + " 中 function 必须符合小写英文单词的 SQL 函数名格式！");
                        }
                    }
                    else if (Functions.SQL_FUNCTION_MAP.containsKey(fun) == false) {
                        throw new IllegalArgumentException("字符 " + method + " 不合法！"
                                + "预编译模式下 @column:\"column0,column1:alias;function0(arg0,arg1,...);function1(...):alias...\""
                                + " 中 function 必须符合小写英文单词的 SQL 函数名格式！且必须是后端允许调用的 SQL 函数!");
                    }
                }
            }

            boolean isColumn = start < 0;

            String ckeys[] = getFunctionString(expression,tableAlias);
//            String[] ckeys = StringUtil.split(isColumn ? expression : expression.substring(start + 1, end));
//            String quote = "`";
//
//
//            //			if (isPrepared()) { //不能通过 ? 来代替，SELECT 'id','name' 返回的就是 id:"id", name:"name"，而不是数据库里的值！
//            if (ckeys != null && ckeys.length > 0) {
//
//                boolean distinct;
//                String origin;
//                String alias;
//                int index;
//                for (int j = 0; j < ckeys.length; j++) {
//                    index = isColumn ? ckeys[j].lastIndexOf(":") : -1; //StringUtil.split返回数组中，子项不会有null
//                    origin = index < 0 ? ckeys[j] : ckeys[j].substring(0, index); //获取 ：之前的
//                    alias = index < 0 ? null : ckeys[j].substring(index + 1);
//
//                    distinct = j <= 0 && origin.startsWith(PREFFIX_DISTINCT);// 判断是否是distinct
//                    if (distinct) {
//                        origin = origin.substring(PREFFIX_DISTINCT.length()); //获取distinct 自后的
//                    }
//
////                    if (isColumn) {
////                            if (StringUtil.isName(origin) == false || (alias != null && StringUtil.isName(alias) == false)) {
////                                throw new IllegalArgumentException("字符 " + ckeys[j] + " 不合法！"
////                                        + "预编译模式下 @column:value 中 value里面用 , 分割的每一项"
////                                        + " column:alias 中 column 必须是1个单词！如果有alias，则alias也必须为1个单词！"
////                                        + "DISTINCT 必须全大写，且后面必须有且只有 1 个空格！其它情况不允许空格！");
////                            }
////                        }
////                        else {
////                            //								if ((StringUtil.isName(origin) == false || origin.startsWith("_"))) {
////                            if (origin.startsWith("_") || origin.contains("--") || PATTERN_FUNCTION.matcher(origin).matches() == false) {
////                                throw new IllegalArgumentException("字符 " + ckeys[j] + " 不合法！"
////                                        + "预编译模式下 @column:\"column0,column1:alias;function0(arg0,arg1,...);function1(...):alias...\""
////                                        + " 中所有 arg 都必须是1个不以 _ 开头的单词 或者符合正则表达式 " + PATTERN_FUNCTION + " 且不包含连续减号 -- ！DISTINCT 必须全大写，且后面必须有且只有 1 个空格！其它情况不允许空格！");
////                            }
////                        }
//
//                    //JOIN 副表不再在外层加副表名前缀 userId AS `Commet.userId`， 而是直接 userId AS `userId`
//                    boolean isName = false;
//                    if (StringUtil.isNumer(origin)) {
//                        //do nothing
//                    }
//                    else if (StringUtil.isName(origin)) {
//                        origin = quote + origin + quote;
//                        isName = true;
//                    }
//                    else {
//                        //if(origin.startsWith("%s"))
//                        //	origin =  getValue(origin.substring(2)).toString();
//                        origin = getValue(origin).toString();
//                    }
//
//                    if (isName) {
//                        ckeys[j] = tableAlias + "." + origin;
//                        //							if (isColumn) {
//                        //								ckeys[j] += " AS " + quote + (isMain() ? "" : tableAlias + ".") + (StringUtil.isEmpty(alias, true) ? origin : alias) + quote;
//                        //							}
//                        if (isColumn && StringUtil.isEmpty(alias, true) == false) {
//                            ckeys[j] += " AS " + quote + alias + quote;
//                        }
//                    } else {
//                        ckeys[j] = origin + (StringUtil.isEmpty(alias, true) ? "" : " AS " + quote + alias + quote);
//                    }
//
//                    if (distinct) {
//                        ckeys[j] = PREFFIX_DISTINCT + ckeys[j];
//                    }
//                }
//                //				}
//            }


//            if (isColumn) {
//                keys[i] = StringUtil.getString(ckeys);
//            }
//            else {
//                String suffix = expression.substring(end + 1, expression.length()); //:contactCount
//                int index = suffix.lastIndexOf(":");
//                String alias = index < 0 ? "" : suffix.substring(index + 1); //contactCount
//                suffix = index < 0 ? suffix : suffix.substring(0, index);
//
//                if (alias.isEmpty() == false && StringUtil.isName(alias) == false) {
//                    throw new IllegalArgumentException("字符串 " + alias + " 不合法！"
//                            + "预编译模式下 @column:value 中 value里面用 ; 分割的每一项"
//                            + " function(arg0,arg1,...):alias 中 alias 必须是1个单词！并且不要有多余的空格！");
//                }
//
//                if (suffix.isEmpty() == false && (((String) suffix).contains("--") || ((String) suffix).contains("/*") || PATTERN_RANGE.matcher((String) suffix).matches() == false)) {
//                    throw new UnsupportedOperationException("字符串 " + suffix + " 不合法！"
//                            + "预编译模式下 @column:\"column?value;function(arg0,arg1,...)?value...\""
//                            + " 中 ?value 必须符合正则表达式 " + PATTERN_RANGE + " 且不包含连续减号 -- 或注释符 /* ！不允许多余的空格！");
//                }
//
//                String origin = method + "(" + StringUtil.getString(ckeys) + ")" + suffix;
//                //					if (isKeyPrefix()) {
//                //						keys[i] = origin + " AS " + quote + (isMain() ? "" : tableAlias + ".") + (StringUtil.isEmpty(alias, true) ? method : alias) + quote;
//                //					}
//                //					else {
//                keys[i] = origin + (StringUtil.isEmpty(alias, true) ? "" : " AS " + quote + alias + quote);
//                //					}
//            }
//
        }

        String c = StringUtil.getString(keys);
        return c;
    }

    public boolean isPrepared() {
        return true;
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
        return (value instanceof Number || value instanceof Boolean) ? value :  "'" + value + "'"; //MySQL 隐式转换用不了索引
    }
    // expresion 代表@column中一个“;”分割的参数
    private String[] getFunctionString(String expression,String tableAlias) {
        boolean isColumn  = expression.indexOf("(")<0;
        // 函数 fun(agr0,agr1..) ckeys 代表

        String[] ckeys = StringUtil.split(isColumn ? expression : expression.substring(expression.indexOf("(")+ 1,expression.lastIndexOf(")")));
        String quote = "`";
        if (ckeys != null && ckeys.length > 0) {
            boolean distinct;
            String origin;
            for (int j = 0; j < ckeys.length; j++) {
                if (ckeys[j].indexOf("(") > 0) {
                    String  subfuntion[]= getFunctionString(ckeys[j],tableAlias);
                    String suffix = expression.substring(ckeys[j].lastIndexOf(")") + 1, expression.length()); //:contactCount
                    int index = suffix.lastIndexOf(":");
                    String alias = index < 0 ? "" : suffix.substring(index + 1); //contactCount
                    suffix = index < 0 ? suffix : suffix.substring(0, index);
                    String  method = ckeys[j].substring(0,ckeys[j].indexOf("(") );
//                    if (alias.isEmpty() == false && StringUtil.isName(alias) == false) {
//                        throw new IllegalArgumentException("字符串 " + alias + " 不合法！"
//                                + "预编译模式下 @column:value 中 value里面用 ; 分割的每一项"
//                                + " function(arg0,arg1,...):alias 中 alias 必须是1个单词！并且不要有多余的空格！");
//                    }
//
//                    if (suffix.isEmpty() == false && (((String) suffix).contains("--") || ((String) suffix).contains("/*") || PATTERN_RANGE.matcher((String) suffix).matches() == false)) {
//                        throw new UnsupportedOperationException("字符串 " + suffix + " 不合法！"
//                                + "预编译模式下 @column:\"column?value;function(arg0,arg1,...)?value...\""
//                                + " 中 ?value 必须符合正则表达式 " + PATTERN_RANGE + " 且不包含连续减号 -- 或注释符 /* ！不允许多余的空格！");
//                    }
                    origin = method + "(" + StringUtil.getString(subfuntion) + ")" + suffix;
                    ckeys[j] = origin + (StringUtil.isEmpty(alias, true) ? "" : " AS " + quote + alias + quote);

                } else {
                    int index = isColumn ? ckeys[j].lastIndexOf(":") : -1; //StringUtil.split返回数组中，子项不会有null
                    origin = index < 0 ? ckeys[j] : ckeys[j].substring(0, index); //获取 ：之前的
                    String alias = index < 0 ? null : ckeys[j].substring(index + 1); //获取别名

                    distinct = j <= 0 && origin.startsWith(PREFFIX_DISTINCT);// 判断是否是distinct开头
                    if (distinct) {
                        origin = origin.substring(PREFFIX_DISTINCT.length()); //如果是 获取distinct后的字段
                    }
                    //解析 cast(date as datetime)
                    origin = getSpaceFunctionParam(origin);

                    if (isPrepared()) {
                        if (isColumn) {
                            if (StringUtil.isName(origin) == false || (alias != null && StringUtil.isName(alias) == false)) {
                                throw new IllegalArgumentException("字符 " + ckeys[j] + " 不合法！"
                                        + "预编译模式下 @column:value 中 value里面用 , 分割的每一项"
                                        + " column:alias 中 column 必须是1个单词！如果有alias，则alias也必须为1个单词！"
                                        + "DISTINCT 必须全大写，且后面必须有且只有 1 个空格！其它情况不允许空格！");
                            }
                        } else {
                            //								if ((StringUtil.isName(origin) == false || origin.startsWith("_"))) {
                            if (origin.startsWith("_") || origin.contains("--") || PATTERN_FUNCTION.matcher(origin).matches() == false) {
                                throw new IllegalArgumentException("字符 " + ckeys[j] + " 不合法！"
                                        + "预编译模式下 @column:\"column0,column1:alias;function0(arg0,arg1,...);function1(...):alias...\""
                                        + " 中所有 arg 都必须是1个不以 _ 开头的单词 或者符合正则表达式 " + PATTERN_FUNCTION + " 且不包含连续减号 -- ！DISTINCT 必须全大写，且后面必须有且只有 1 个空格！其它情况不允许空格！");
                            }
                        }
                    }

                    //JOIN 副表不再在外层加副表名前缀 userId AS `Commet.userId`， 而是直接 userId AS `userId`

                    boolean isName = false;
                    if (StringUtil.isNumer(origin)) {
                        //do nothing
                    } else if (StringUtil.isName(origin)) {
                        origin = quote + origin + quote;
                        isName = true;
                    } else {
                        origin = getValue(origin).toString();
                    }
                    if (isName) {
                        ckeys[j] = tableAlias + "." + origin;
                        //							if (isColumn) {
                        //								ckeys[j] += " AS " + quote + (isMain() ? "" : tableAlias + ".") + (StringUtil.isEmpty(alias, true) ? origin : alias) + quote;
                        //							}
                        if (isColumn && StringUtil.isEmpty(alias, true) == false) {
                            ckeys[j] += " AS " + quote + alias + quote;
                        }
                    } else {
                        ckeys[j] = origin + (StringUtil.isEmpty(alias, true) ? "" : " AS " + quote + alias + quote);
                    }

                    if (distinct) {
                        ckeys[j] = PREFFIX_DISTINCT + ckeys[j];
                    }
                }
            }
        }
        return  ckeys;

    }

    private String getSpaceFunctionParam(String origin) {
        String quote = "`";
        String param[] = origin.split("\\s+");
        for (int i = 0; i < param.length; i++) {
            if("".equals(RAW_MAP.get(param[i]))){
                // do nothing
            }if (StringUtil.isNumer(param[i])) {
                //do nothing
            } else if (StringUtil.isName(param[i])) {
                param[i] = quote + origin + quote;
            } else {
                param[i]= getValue(origin).toString();
            }
        }
        return  StringUtil.join(param," ");
    }

    public static void main(String[] args) {
        new FunctionPrase().getColumnString();
    }
}
