package template.mianshi;

public class MyHashMap<K,V> {

    Node2[]  table;
    int size;
    int len =16;

    public MyHashMap(){
        table = new Node2[16];
    }

    public void put(K key,V value){

        //定义了新的节点对象
        Node2 node = new Node2();
        node.hash = myhash(key.hashCode());
        node.key = key;
        node.value = value;
        node.next = null;

        int index = node.hash&(len-1);
        Node2 nod = table[index];
        if(nod == null){
            table[index]=node;
            size++;
        }else{
            //遍历链表则找到是否有重复，没有重复则跟在尾部，有重复的则更新。
            while(nod.next != null){
                if(nod.key.equals(key)){
                    nod.value = value;
                    break;
                }
                nod = nod.next;
            }
            if(nod.key == key){
                nod.value =value;
            }else{
                nod.next = node;
                size++;
            }
        }
    }

    public int myhash(Object key){
         int h;
        return  key==null?0:(h=key.hashCode())^(h>>>16);
    }


    public String toString(){
        //保存我们的{10："aa",11:"bb".....}的字符串对
        StringBuilder sb = new StringBuilder("{");
        //遍历bucket数组
        for(int i=0;i<table.length;i++){
            Node2 temp = table[i];
            if(temp !=null){
                //遍历数组
                while(temp !=null){
                    sb.append(temp.key+":"+temp.value+",");
                    temp = temp.next;
                }
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    public V get(K key){
        //根据key对象查找hashcode 然后查找对应的bucket数组，遍历链表
        int hashCode = myhash(key);
        int index = hashCode&(len-1);
        Node2 temp = table[hashCode];
        if(temp != null){
            while(temp != null){
                if(temp.key.equals(key)){
                    return (V)temp.value;
                }else{
                    temp = temp.next;
                }
            }
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<String,Integer>  myHashMap =new MyHashMap<>();
        myHashMap.put("123",312777);
        myHashMap.put("12",312999);
        myHashMap.put("3",31233);
        myHashMap.put("1323",312555);
        myHashMap.put("1233",31265);
        myHashMap.put("12453",3512);
        System.out.println(myHashMap.toString());
    }

}
//用于hashMap中
class Node2<k,v>{

    int hash;
    k key;
    v value;
    Node2 next;


}




