package Contest.week.T213;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class canFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for(int j=0;j<pieces.length;j++){
            int index=0;
            int len=pieces[j].length;
            int flag=0;
            for(int k=0;k<arr.length;k++){
                if(flag==1&&arr[k]!=pieces[j][index]) return false;
                if(arr[k]==pieces[j][index]){
                    index++;
                    flag=1;
                    if(index==len)  break;
                }

            }
            if(index!=len) return false;
        }
        return true;
    }
    public int numDifferentIntegers(String word) {
        int right  =0 ;
        int count = 0;
        HashSet<Integer>  set  = new HashSet<>();

        for (int i=0;i<word.length();i++){
            if(Character.isDigit(word.charAt(i))){
                count=count*10+word.charAt(i)-'0';
            }else{
                if(count!=0) set.add(count);
                count=0;
            }
        }
    return  set.size();
    }
    public int reinitializePermutation(int n) {
        int perm[]  =new int[n];
        for(int i=0;i<n;i++) perm[i] = i;
        int arr[] = new int[n];
        int res=0;
        do {

            res++;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) arr[i] = perm[i / 2];
                if (i % 2 == 1) arr[i] = perm[n / 2 + (i - 1) / 2];
            }
            }while (Arrays.equals(arr, perm)) ;
            return res;
        }
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String>  map = new HashMap<>();
        for(List<String>  list :knowledge){
            map.put(list.get(0),list.get(1));
        }
        int  first =0;
        int last =0;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                String sss  = s.substring(first,i);
                res.append(sss);
                first=i;
            }
            if(s.charAt(i)==')'){
                last =  i;
                String ss = s.substring(first+1,last);
                res.append(map.get(ss));
                first = last+1;
            }



        }
        return  res.toString();

    }
}
