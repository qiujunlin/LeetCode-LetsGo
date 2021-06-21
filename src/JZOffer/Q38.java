package JZOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q38 {
    List<String> list = new ArrayList<>();
    boolean vis[];
    public String[] permutation(String s) {
        vis = new boolean[s.length()];
        char ch[] = s.toCharArray();
        Arrays.sort(ch);
        StringBuffer stringBuffer = new StringBuffer();
        dfs(ch,0,stringBuffer);
        return  list.toArray(new String[list.size()]);

    }

    private void dfs(char[] ch, int i, StringBuffer stringBuffer) {
        if(i==ch.length){
            list.add(stringBuffer.toString());
            return;
        }
        for(int j=0;j<ch.length;j++){
            if(!vis[j]){
                if(j>0&&!vis[j-1]&&ch[j]==ch[j-1]) continue;
                stringBuffer.append(ch[j]);
                vis[j]=true;
                dfs(ch,i+1,stringBuffer);
               // stringBuffer = stringBuffer.subSequence(0,stringBuffer.length());
               stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length()-1);
               vis[j]=false;

            }
        }
    }
}
