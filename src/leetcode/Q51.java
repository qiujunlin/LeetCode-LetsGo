package leetcode;

import java.util.*;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean col[] = new boolean[n];
        char que[][] = new char[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) que[i][j] = '.';
        dfs(res, col, 0, n, que);
        return res;
    }

    private void dfs(List<List<String>> res, boolean[] col, int r, int n, char que[][]) {
        if (r == n) {
            addres(que, res, n);
            return;
        }

        for (int c = 0; c < n; c++) {
            boolean valid = check(que, col, n, c, r);
            if (!valid) continue;
            col[c] = true;
            que[r][c] = 'Q';
            dfs(res, col, r + 1, n, que);
            col[c] = false;
            que[r][c] = '.';
        }
        return ;
    }

    private boolean check(char[][] que, boolean[] col, int n, int c, int r) {
        if (col[c]) return false;
        // 检查 45度角是否有皇后
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (que[i][j] == 'Q') {
                return false;
            }
        }
        // 检查 135度角是否有皇后
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (que[i][j] == 'Q') {
                return false;
            }
        }
        return  false;
    }

    private void addres(char[][] que, List<List<String>> res, int n) {
        List<String> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder a = new StringBuilder();
            for (int j = 0; j < n; j++) {
                a.append(que[i][j]);
            }
            l.add(a.toString());
        }
        res.add(l);
    }
}
