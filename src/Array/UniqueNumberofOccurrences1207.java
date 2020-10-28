package Array;
import  java.util.*;
public class UniqueNumberofOccurrences1207 {

    //第一遍解法
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])==null){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        Set<Integer> set= new HashSet<>();
        for (Integer a:map.keySet()) {
            if(set.contains(map.get(a))){
                return false;
            }else{
                set.add(map.get(a));
            }
        }
        return true;
    }
    //第二遍 思路一样 修改代码 简洁一点
    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer,Integer> map= new HashMap<>();
        for (int a:arr) {
            map.put(a ,map.getOrDefault(a, 0) + 1);
        }
        Set<Integer> set= new HashSet<>(map.values());
        return map.size()==set.size();
    }
}
