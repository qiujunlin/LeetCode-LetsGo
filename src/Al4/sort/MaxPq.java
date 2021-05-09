package Al4.sort;

public class MaxPq<Key extends  Comparable>{
    private Key[]  pq;
    private int N;
}
interface  dad{
    int compare();
}class son implements  dad{

    @Override
    public int compare() {
        return 0;
    }

    public static void main(String[] args) {
        dad[] a = new dad[10];
        son[] b =(son[]) a;
    }
}
