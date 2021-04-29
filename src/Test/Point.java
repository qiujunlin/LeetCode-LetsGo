package Test;

import java.util.Objects;
import java.util.Random;

public class Point {
    private double x;
    private double y;
    public  Point(){
        this.x =0.0;
        this.y=0.0;
    }

    public  Point(double x, double y){
        this.x =x;
        this. y =y;
    }
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class  Q1{
    private  Point[] arr;
    public  Q1(){
        this.arr = new Point[50];
        Random rand = new Random();
        for(int i=0;i<50;i++){
            arr[i] = new Point(rand.nextDouble(),rand.nextDouble());//随机赋值
        }

    }
    //判断是否有相等点
    public  boolean judge(){
        for(int i=0;i<50;i++){
            for(int j=i+1;j<50;j++){
                if(arr[i].equals(arr[j])) return true;
            }
        }
        return  false;
    }

    public double[] distance(Point point){
        //返回point与其他所有节点的距离
         double res[]  = new double[50];
            for(int i=0;i<50;i++){
                res[i] = getTwoDistance(point,arr[i]);
            }
            return  res;
    }
    public  int [] neartwopoint(){
        //返回最近两个节点的下标
        int  res[ ] = new int[2];
        double dis = Double.MAX_VALUE;
        for(int i=0;i<50;i++){
            for(int j=i+1;j<50;j++){
                if(getTwoDistance(arr[i],arr[j])<dis){
                    dis = getTwoDistance(arr[i],arr[j]);
                    res[0] = i;
                    res[1]=j;

                }
            }
        }
        return res;

    }
    //返回两个节点的距离
    private  double getTwoDistance(Point x,Point y){
        return Math.sqrt(Math.pow(x.getX()-y.getX(),2)+Math.pow(x.getY()-y.getY(),0));
    }
}
class  Triangle{
    private  Point x;
    private  Point y;
    private  Point z;
    public  Triangle(Point x,Point y ,Point z) {
        this.x = x;
        this.y = y;
        this.z = z;
        if(!judge(x.getX(),x.getY(),y.getX(),y.getY(),z.getX(),z.getY())) {
            throw new ArithmeticException("不能构成三角形");
        }
    }
    public  Triangle(){

    }
   //能否构成三角形
    public  boolean judge(double x1,double y1,double x2,double y2,double x3,double y3){
        double a,b,c;
        a=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        b=Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
        c=Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
        if(x1==x2&&x1==x3) return  false;
        if(y1==y2&&y1==y3) return  false;
        if(a+b<c||b+c<a||c+a<b) return false;
        else return true;
    }
    //周长
    public double length(double x1,double y1,double x2,double y2,double x3,double y3)
    {
        double a,b,c;
        a=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        b=Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
        c=Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
        return  a+b+c;
    }
    //面积
    double area(double x1,double y1,double x2,double y2,double x3,double y3)
    {
        double a,b,c,s;
        a=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        b=Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
        c=Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
        s=(a+b+c)/2;
        return  Math.sqrt(s* (s - a) * (s - b) * (s - c));

    }


}
class  Test{
    public static void main(String[] args) {
        Point x = new Point(0,1);
        Point y = new Point(0,1);
        Point z = new Point(0,2);
        try{
            Triangle  triangle = new Triangle(x,y,z);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
}