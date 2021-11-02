package leetcode;

public class Q335 {

    public boolean isSelfCrossing(int[] distance) {
        //https://code83.ide.aliyun.com/share-clue/1260256269483624-5/1d3f2c7a-0d5c-4736-879a-04c3da0570ad
        int  len =  distance.length;
        if(len<4) return  false;
        //
        for (int i = 3; i <len ; i++) {
              //  n if()
            if (distance[i-1]<=distance[i-3]&&distance[i]>=distance[i-2]) return  true;
            if(i>=4&&distance[i-1]==distance[i-3]&&distance[i]+distance[i-4]>=distance[i-2]) return  true;
            if(i>=5&&distance[i-1]<=distance[i-3]&& distance[i-1]+distance[i-5]>=distance[i-3]&&distance[i-2]>distance[i-4]&&distance[i]+distance[i-4]>=distance[i-2]) return  true;
        }
        return  false;
    }

}
