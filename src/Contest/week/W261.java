package Contest.week;



public class W261 {

    public static void main(String[] args) {
        System.out.println("hdasj");
    }
    public int minimumMoves(String s) {
       int res  =0;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='X'){
                res++;
                i+=2;
            }
        }
        return  res;
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
         int m =  rolls.length;
         int summ =0;
        for (int i = 0; i <rolls.length ; i++) {
            summ+=rolls[i];
        }
        int sumn =  (n+m)*mean-summ;
        int res[] =  new int[n];
        int abg =  sumn/n;
        int c =  sumn%n;
        for (int i = 0; i <n ; i++) {
            res[i] = abg;
        }
        for (int i = 0; i <n ; i++) {
            res[i]++;
        }
        return  res;


    }


}
