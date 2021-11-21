package Contest.week;

public class W269 {
    public static void main(String[] args) {
        System.out.println( "达到");
    }
    public int maxDistance(int[] colors) {
        int max =0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = i+1; j < colors.length; j++) {
                if(colors[i]!=colors[j]){
                    max =Math.max(j-i,max);
                }
            }
        }
        return  max;


    }

    /**
     * [3,2,4,2,1]
     * 6    17
     * @param plants
     * @param capacity
     * @return
     */
    public int wateringPlants(int[] plants, int capacity) {
        int res =0;
        int index  =1;
        int count =0;
        int capacity1 =capacity;
        while (index<plants.length){
            if(capacity-plants[index]<0){
                capacity = capacity1;
                capacity -= plants[index];
                res+=index;
                res+=index+1;
                res++;
            }else{
                capacity-=plants[index];
            }
            res++;
            index++;


        }
        return  res;

    }

}
