## Stringbuilder

StringBuilder  的 deleteCharAt(int index) 方法 删除某个字符 ，常用来删除末尾字符骚操作，不需要截取字符串了。

## List集合初始化

1. Arrays

```
List<String> jdks = Arrays.asList("JDK6", "JDK8", "JDK10");
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

集合的拷贝方式

**list转数组**	list.toArray(T[]  a); 将list转化为你所需要类型的数组

**数组转list**  Arrays.asList(str)		

因为asList()返回的列表的大小是固定的。事实上，返回的列表不是java.util.ArrayList类，而是定义在java.util.Arrays中一个私有静态类java.util.Arrays.ArrayList我们知道ArrayList的实现本质上是一个数组，而asList()返回的列表是由原始数组支持的固定大小的列表。这种情况下，如果添加或删除列表中的元素，程序会抛出异常UnsupportedOperationException。


## 数组比较

数组相等的条件不仅要求数组元素的个数必须相等，而且要求对应位置的元素也相等。Arrays 类提供了 equals() 方法比较整个数组。语法如下：

```
Arrays.equals(arrayA, arrayB);
```

## HashMap

computeIfAbsent()

方法对 hashMap 中指定 key 的值进行重新计算，如果不存在这个 key，则添加到 hasMap 中。

computeIfAbsent() 方法的语法为：

```
hashmap.computeIfAbsent(K key, Function remappingFunction)
```

getOrDefault：仅仅是返回值，如果不存在返回指定的默认值，不修改map的结构
  putIfAbsent：key不存在时，塞一个值，不应该关心返回值
  computeIfAbsent：获取key对应的value，不存在时塞一个并返回

replace() 替换 hashMap 中是指定的 key 对应的 value。 

## String

1. trim() 去除两边空格

2. string.Join()方法

   连接指定数组的元素或集合的成员，在每个元素或成员之间使用指定的分隔符。重载此成员。
      Join(String, IEnumerable<String>)         串联类型为 String 的 IEnumerable<T> 构造集合的成员，其中在每个成员之间使用指定的分隔符。

   Join<T>(String, IEnumerable<T>)          串联集合的成员，其中在每个成员之间使用指定的分隔符。   Join(String, Object[])          串联对象数组的各个元素，其中在每个元素之间使用指定的分隔符。   Join(String, String[])          串联字符串数组的所有元素，其中在每个元素之间使用指定的分隔符。   

## TreeMap

**增添元素**

- V put(K key, V value)：将指定映射放入该TreeMap中

- V putAll(Map map)：将指定map放入该TreeMap中

- 批量增加 

  ```
  HashMap<Integer,Integer> map = new HashMap(){{
      put(1,2);
      put(2,2);
     put(3,2);
  }};
  ```

**删除元素**

- void clear()：清空TreeMap中的所有元素
- V remove(Object key)：从TreeMap中移除指定key对应的映射

**修改元素**

- V replace(K key, V value)：替换指定key对应的value值

**查找元素**

* floorKey返回小于等于给定键的最大键；如果不存在这样的键，则返回null。

* ceilingKey（找到大于等于该key的最小值）：

* HigherKey()方法用于返回比给定键元素(key_ele)高的最低键值元素。

* （lowerKey()方法用于检索低于给定键元素的最大键元素值

- boolean containsKey(Object key)：判断该TreeMap中是否包含指定key的映射
- boolean containsValue(Object value)：判断该TreeMap中是否包含有关指定value的映射
- Map.Entry<K, V> firstEntry()：返回该TreeMap的第一个（最小的）映射
- K firstKey()：返回该TreeMap的第一个（最小的）映射的key
- Map.Entry<K, V> lastEntry()：返回该TreeMap的最后一个（最大的）映射
- K lastKey()：返回该TreeMap的最后一个（最大的）映射的key
- v get(K key)：返回指定key对应的value
- SortedMap<K, V> headMap(K toKey)：返回该TreeMap中严格小于指定key的映射集合
- SortedMap<K, V> subMap(K fromKey, K toKey)：返回该TreeMap中指定范围的映射集合（大于等于fromKey，小于toKey）

遍历方式 JSK8:

*// JDK8的迭代方式* infoMap.forEach((key, value) -> {    System.out.println(key + "：" + value); });	

在迭代里面进行 return;  相当于 执行下下一次迭代  不是退出迭代

## 注意事项！！

在HashMap中判断key是否重复的依据是根据hash值和equals比较，但是在TreeMap中，判断key是否重复的依据是根据 `comparaTo` 是否为0，如果为0，TreeMap 就认为key是重复的。

