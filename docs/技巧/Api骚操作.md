## Stringbuilder

StringBuilder  的 deleteCharAt(int index) 方法 删除某个字符 ，常用来删除末尾字符骚操作，不需要截取字符串了。

## List集合初始化

1. Arrays

```
List<String> jdks = asList("JDK6", "JDK8", "JDK10");
Syst
```

注意，上面的 asList 是 Arrays 的静态方法，这里使用了静态导入。这种方式添加的是不可变的 List, 即不能添加、删除等操作，需要警惕。。

> import static java.util.Arrays.asList;

如果要可变，那就使用 ArrayList 再包装一下，如下面所示。

```
List<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3"));
```

2.JDK8 Stream

```java
List<String> colors = Stream.of("blue", "red", "yellow").collect(toList());
```

## 数组比较

数组相等的条件不仅要求数组元素的个数必须相等，而且要求对应位置的元素也相等。Arrays 类提供了 equals() 方法比较整个数组。语法如下：

```
Arrays.equals(arrayA, arrayB);
```