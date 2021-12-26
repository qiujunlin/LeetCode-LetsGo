package Contest.week;

import Test.Main;
import com.sun.scenario.effect.impl.sw.java.JSWRendererDelegate;

import java.util.*;

public class DW68 {
    public static void main(String[] args) {
        System.out.println("haha");
       // HashMap<Integer,Integer> map  = new HashMap<>();

    }
//"())(()(()(())()())(())((())(()())((())))))(((((((())(()))))("
//        "100011110110011011010111100111011101111110000101001101001111" false
    /**
     * ")("
     * "00"  true;
     *
     * "((()(()()))()((()()))))()((()(()"
     * "10111100100101001110100010001001"   true
     * @param s
     * @param locked
     * @return
     */
    public boolean canBeValid(String s, String locked) {
         int l =0;
         int r = 0;
         int change =0;
        for (int i = 0; i < s.length() ; i++) {
            if(locked.charAt(i)=='1'){
                if(s.charAt(i)==')'){
                    l++;
                }
                if(change<r) return  false;
            }else{
                change++;
            }

             //if(locked.charAt(i)=='0') change++;
        }
        for (int i = s.length()-1; i >=0 ; i--) {
            if(locked.charAt(i)=='1'){
                if(s.charAt(i)=='('){
                    l++;
                }
                if(change<r) return  false;
            }else{
                change++;
            }

            //if(locked.charAt(i)=='0') change++;
        }
        return  true;

       // return  change>=;


    }
    public int mostWordsFound(String[] sentences) {

        int max  = 0;
        for(String s  : sentences){
              max=Math.max(max,s.split(" ").length);
        }
        return  max;

    }
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, HashSet<String>>  map = new HashMap<>();
        for (int i = 0; i <recipes.length ; i++) {
            HashSet<String> set = map.computeIfAbsent(recipes[i],(key)->new HashSet<>());
            for(String s :  ingredients.get(i)){
                set.add(s);
            }
        }
        HashSet<String>  set  = new HashSet<>();
        for(String s :  supplies)  set.add(s);
        List<String>  res = new ArrayList<>();
        for(String s: recipes){
            HashSet<String> vis  = new HashSet<>();
            vis.add(s);
            if(dfs(set,map,s,vis)){
                res.add(s);
            }
        }
        return  res;




    }

    private boolean dfs(HashSet<String> set, HashMap<String, HashSet<String>> map, String s,HashSet<String> vis ) {

        if(set.contains(s)) return  true;
        if(map.get(s)==null) return  false;
        for(String ss: map.get(s)){
            if(vis.contains(ss)) return  false;
            if(!set.contains(ss)){
                if(map.containsKey(ss)){
                    vis.add(ss);
                    for(String temp :  map.get(ss)){
                        //if(set.contains(temp)) continue;
                        if(!dfs(set,map,temp,vis)) return  false;
                    }

                }else{
                    return  false;
                }
            }
        }
        return  true;
    }

}
