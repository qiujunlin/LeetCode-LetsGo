package Contest.week;

import java.util.*;

public class W290 {
    public static void main(String[] args) {
        System.out.println("dsa");
    }
    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer,Integer>  map =new HashMap<>();
        for(int a[] : nums){
            for(int n :a){
                map.put(n,map.getOrDefault(n,0)+1);
            }
        }
        int len  = nums.length;
        ArrayList<Integer>  l =new ArrayList<>();
        for(int a:map.keySet()){
            if(map.get(a)==len) l.add(a);
        }
        Collections.sort(l);
        return  l;

    }
    public int countLatticePoints(int[][] circles) {
        int res  =0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <=100 ; j++) {
                for (int k = 0; k <circles.length ; k++) {
                     int a =Math.abs(i-circles[k][0]);
                     int b =Math.abs(j-circles[k][1]);
                     int c =circles[k][2];
                     if(a*a+b*b<c*c){
                         res++;
                         break;
                     }
                }
            }
        }
        return  res;
    }
    public int[] countRectangles(int[][] rectangles, int[][] points) {
             TreeMap<Integer,Integer>  m1 =new TreeMap<>();
        TreeMap<Integer,Integer>  m2 =new TreeMap<>();
        for (int a[] :rectangles) {
            m1.put(0,m1.getOrDefault(0,0)+1);
            m1.put(a[1]+1,m1.getOrDefault(a[1]+1,0)-1);
            m2.put(0,m1.getOrDefault(0,0)+1);
            m2.put(a[1]+1,m1.getOrDefault(a[1]+1,0)-1);
        }
        ArrayList<Integer> l =new ArrayList<>();
        for(int a :m1.keySet()){
            Integer c =m1.get(m1.lowerKey(a));
            if(c==null)continue;
            m1.put(a,m1.get(a) + m1.get(c));
        }
        for(int a :m2.keySet()){
            Integer c =m2.get(m2.lowerKey(a));
            if(c==null)continue;
            m2.put(a,m2.get(a) + m2.get(c));
        }
        int res[] = new int[points.length];
        for (int i = 0; i <points.length ; i++) {
             int x =  points[i][0];
             int y =  points[i][1];
             int n1 = m1.ceilingKey(x);
             int n2 = m2.ceilingKey(y);
             res[i] =Math.min(n1,n2);
        }
        return  res;
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int temp[] = new int[persons.length];
        HashSet<Integer>  set =new HashSet<>();
        for (int i = 0; i <persons.length ; i++) {
            temp[i] = persons[i];
            set.add(persons[i]);
        }
        persons= new int[set.size()];
        int k = 0;
        for (int a : set) {
            persons[k++] = a;
        }
        int m[] =new int[set.size()];
       // HashMap<Integer,Integer>  map =new HashMap<>();
        Arrays.sort(persons);
        TreeMap<Integer,Integer> map1 =new TreeMap<>();
        for (int i = 0; i <persons.length ; i++) {
            map1.put(persons[i],i);
        }
        for(int a[] :  flowers){
            Integer l  =map1.ceilingKey(a[0]);
            Integer r =map1.floorKey(a[1]);
            if(l==null||r==null)  continue;
            int lindex =  map1.get(l);
            int rindex =  map1.get(r);
            for (int i = lindex; i <=rindex ; i++) {
                m[lindex] +=1;
                m[rindex+1] -=1;


            }
        }
        for (int i = 1; i <m.length ; i++) {
            m[i] += m[i-1];
        }
        HashMap<Integer,Integer> c =new HashMap<>();
        for (int i = 0; i < persons.length; i++) {
            c.put(persons[i],m[i]);
        }

        // System.out.println(map);
        int res [] = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            if(c.containsKey(temp[i]))
                res[i] = c.get(temp[i]);
        }
        return res;
    }

}
