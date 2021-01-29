package com.eh;


class Solution {

    int count;

    public int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];
        count = 0;
        dfs(0, 0, m, n, k, flag);
        return count;
    }
    public void dfs(int x, int y, int m, int n, int k, boolean[][] flag) {
        if (x < m && x >=0 && y >= 0 && y < n && sum(x, y) <= k && !flag[x][y]) {
            flag[x][y] = true;
            count++;
            dfs(x + 1, y, m, n, k, flag);
            dfs(x - 1, y, m, n, k, flag);
            dfs(x, y + 1, m, n, k, flag);
            dfs(x, y - 1, m, n, k, flag);
        }
    }
    public int sum(int a, int b) {
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a = a / 10;
        }
        while (b != 0) {
            sum += b % 10;
            b = b / 10;
        }
        return sum;
    }

}
