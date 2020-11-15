package WeeklyContest.T213;

public class CheckArrayFormationThroughConcatenation5554 {
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
}
