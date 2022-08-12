import java.text.SimpleDateFormat;
import java.util.*;
public  class  Main{
    public static void main(String[] args) throws  Exception {
        Scanner scanner =new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(judge(s));




    }

    private static int judge(String s) {
        if(s.length()<5) return  -1;
        HashSet<Character> set =new HashSet<>();
        ArrayList<Integer> l=new ArrayList<>();
        set.add('f');
        set.add('a');
        set.add('i');
        set.add('l');
        set.add('e');
        set.add('d');
        int hash[] =new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c=  s.charAt(i);
            if(c=='f') l.add(i);
            if(!set.contains(c)) return  -1;
            hash[c-'a']++;

        }
        HashSet<Integer> set1 =new HashSet<>();

        String te =  "failed";
        for (int i = 0; i < te.length(); i++) {
            set1.add(hash[te.charAt(i)-'a']);
        }
        if(set1.size()>1) return  -1;

        int c[] = new int[s.length()];
        boolean vis[] =new boolean[s.length()];
        for (int i = 0; i <l.size() ; i++) {
            int j = l.get(i);
            int index =0;
            for (int k = j; k <s.length(); k++) {
                if(te.charAt(index)==s.charAt(k)&&!vis[k]) {
                    vis[k]=true; index++;
                }
                if(index==te.length()) break;
                c[k]++;
            }
            if(index!=te.length())return  -1;
        }
        int res =0;
        for (int i = 0; i <c.length ; i++) {
            res =Math.max(c[i],res);

        }
        return  res;
    }
    public static void main1(String[] args) throws  Exception {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String str[] = s.split(" ");
        Arrays.sort(str);
        String res =  "";
        long min = Long.MIN_VALUE;
        for (int i = 0; i < n-1; i++) {
            long r = gettime(str[i],str[i+1]);
            if(r>min) {
                res = str[i];
                min =r;
            }
            // System.out.println(r);
        }
        long r = gettime("00:00:00",str[0]) + gettime(str[n-1],"23:59:59");
        if(r>min) {
            res = str[n-1];
        }

        System.out.println(res);


    }

    private static long gettime(String s, String s1) throws  Exception{
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("HH:mm:ss");
        long end = simpleDateFormat.parse(s1).getTime();
        long start = simpleDateFormat.parse(s).getTime();
        return  end-start;


    }
