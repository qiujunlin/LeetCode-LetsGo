package Test;

import java.util.*;

/**
 * @Classname Tesr3
 * @Description:
 * @Date 2021/1/31 10:53
 * @Created by qiujunlin
 */
class Unino {
    int parent[];
    int count;
    int first = 0;

    public Unino(int len) {
        this.count = len;
        parent = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        return parent[x] == x ? x : find(parent[x]);
    }

    void merge(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != a && y != b) parent[x] = y;
        if (x != a) {
            parent[b] = x;
            first = b;
        } else if (y != b) {
            parent[a] = y;
            first = a;
        }
    }

    boolean connected(int x, int y) {
        int a = find(x);
        int b = find(y);
        return a == b;
    }

    int[] find(int x, int len) {
        ArrayList<Integer> list = new ArrayList<>();
        int res[] = new int[len];
        int i = 0;
        while (parent[x] != x) {
            res[i] = x;
            i++;
            x = parent[x];
        }

        return res;
    }
}

class UnionFind {
    protected int size;
    protected final Map<Integer, Integer> parent = new HashMap<>();

    public UnionFind(int[] orig) {
        for (int t : orig) {
            parent.put(t, t);
        }
        size = orig.length;
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == node1) {
            parent.put(root1, node2);
        } else if (root2 == node2) {
            parent.put(root2, node1);
        } else {
            parent.put(node1, node2);
        }
    }

    public int find(int node) {
        while (parent.get(node) != node) node = parent.get(node);
        return node;
    }

}

public class Tesr3 {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int a[] : adjacentPairs) {
            if (map.get(a[0]) == null) map.put(a[0], new ArrayList<>());
            if (map.get(a[1]) == null) map.put(a[1], new ArrayList<>());
            map.get(a[0]).add(a[1]);
            map.get(a[1]).add(a[0]);
        }
        int first = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> a : map.entrySet()) {
            if (a.getValue().size() == 1) {
                first = a.getKey();
                break;
            }
        }
        int res[] = new int[adjacentPairs.length + 1];
        int pre = map.get(first).get(0);
        int preindex = first;
        int index = 0;
        res[index++] = first;
        res[index++] = pre;
        while (true) {
            ArrayList<Integer> list = map.get(pre);
            for (int i : list) {
                if (i != preindex) {
                    preindex = pre;
                    pre = i;
                    res[index++] = i;
                    break;
                    // System.out.println(index+" "+preindex+" "+pre);
                }
            }
            if (index == res.length) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = new Tesr3().restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}});
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


}
