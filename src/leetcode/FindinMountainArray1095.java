package leetcode;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/12
 */
class MountainArray{
    int a[]= new int[100];
    public int  length(){
        return a.length;
    }
    public int get(int index)
    {
        return  a[index];
    }
}
public class FindinMountainArray1095 {

    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            int peek = findmax(mountainArr);
            int leftindex=findleft(target,peek,mountainArr);
            int rightindex=findright(target,peek,mountainArr);
            int res =  Math.min(leftindex,rightindex);
            return res==Integer.MAX_VALUE?-1:res;
        }
        int findmax(MountainArray mountainArr){
            int left=0;int right=mountainArr.length()-1;

            while(left<right){
                int mid = left + (right-left)/2;
                int peek=mountainArr.get(mid);
                //int leftpeek=mountainArr.get(mid-1);
                int rightpeek=mountainArr.get(mid+1);
                if(peek<rightpeek) left=mid+1;
                else right=mid;
            }
            return left;

        }
        int findleft(int target,int peek,MountainArray mountainArr){
            int left=0;int right=peek;
            while(left<right){
                int mid = left + (right - left) / 2;
                if(mountainArr.get(mid)<target){
                    left=mid+1;
                }else right=mid;
            }
            return mountainArr.get(left)==target?left:Integer.MAX_VALUE;
        }
        int findright(int target,int peek,MountainArray mountainArr){
            int left=peek;int right=mountainArr.length()-1;
            while(left<right){
                int mid = left + (right - left) / 2;
                if(mountainArr.get(mid)>target){
                    left=mid+1;
                }else right=mid;
            }
            return mountainArr.get(left)==target?left:Integer.MAX_VALUE;
        }

    }
}
