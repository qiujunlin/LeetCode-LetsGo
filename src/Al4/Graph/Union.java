package Al4.Graph;

public class Union {
    private  int parent[];
    int count  =0 ;
    public Union(int n ){
       this.count = n ;
       this.parent =  new int[n];
       for (int  i =0;i<n;i++) {
           this.parent[i] = i;
       }
    }
    public  void merge(int x,int y){
        int newx = find(x);
        int newy = find(y);
        if(newx==newy) return;
        else{
            parent[newx] = newy;
            count--;
        }
    }
    public int find(int x){
        return  x==parent[x]?(x):(parent[x] = find(parent[x]));
    }
    public boolean isconnected(int x,int y){
        return  find(x) ==find(y);
    }
}
