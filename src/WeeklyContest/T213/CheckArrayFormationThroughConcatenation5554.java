package WeeklyContest.T213;

public class CheckArrayFormationThroughConcatenation5554 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for(int j=0;j<pieces.length;j++){
            int index=0;
            int len=pieces[j].length;
            for(int k=0;k<arr.length;k++){
                if(arr[k]==pieces[j][index]){
                    index++;
                    //if(k==arr.length-1) break;
                    if(index==len)  break;
                }

            }
            if(index!=len) return false;
        }
        return true;
    }
}
