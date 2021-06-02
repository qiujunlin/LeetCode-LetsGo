package WeeklyContest.Lanqiao;

public class QG11E {
    static int count = 0;
    static int direct[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void mai24n(String[] args) {
        boolean vis[][] = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                vis[i][j] = true;
                dfs(vis, i, j, 1);
                vis[i][j] = false;
            }
        }
        System.out.println(count);
    }
    private static void dfs(boolean[][] vis, int x, int y, int num) {
        if (num == 16) {
            count++;
            return;
        }
        for (int k = 0; k < 4; k++) {
            int newx =x+ direct[k][0];
            int newy = y+direct[k][1];
            if (newx < 4 && newy < 4 && newx >= 0 && newy >= 0 && !vis[newx][newy]) {
                vis[newx][newy] = true;
                dfs(vis, newx, newy, num + 1);
                vis[newx][newy] = false;
            }
        }
    }
}
