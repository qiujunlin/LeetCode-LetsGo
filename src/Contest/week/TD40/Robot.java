package Contest.week.TD40;

public class Robot {
    int width = 0;
    int heiht=0;
    int x =0;int y =0;
    int direct =0;
    String directs[] = {"East","North" ,"West","South"};
    public Robot(int width, int height) {
        this.width =width;this.heiht =height;
    }

    public void move(int num) {

        int sum =  width+width+heiht+heiht-4;
        int a= num%sum;
        if(a==0&&num!=0) {
            if(x==0&&y==0){
                direct=3;
            }else if(x==width-1&&y==0){
                direct=0;
            }else if(x==width-1&&y==heiht-1){
                direct=1;
            }else if(x==0&&y==heiht-1){
                direct=2;
            }
        }

        while (a>0){
          //  x+=1;
          if(direct==0){
              x++;
              if(x==width){
                  direct=1;
                  y++;
                  x=width-1;
              }
          }else if(direct==1){
              y++;
              if(y==heiht){
                  direct=2;
                  x--;
                  y=heiht-1;
              }

          }else if(direct==2){
              x--;
              if(x==-1){
                  direct=3;
                  y--;
                  x=0;
              }
          }else {

              y--;
              if(y==-1){
                  direct=0;
                  y=0;
                  x++;
              }
          }
          a--;
        }


    }

    public int[] getPos() {
     return  new int[]{x,y};
    }

    public String getDir() {
        return  directs[direct];

    }
}
