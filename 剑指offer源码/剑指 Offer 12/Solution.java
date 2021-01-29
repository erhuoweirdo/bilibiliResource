package com.eh;


class Solution {
   public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j,0)) return true;结果
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int x, int y, int k) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || word.charAt(k) != board[x][y]) return false;
        if (word.length() - 1 == k) return true;
        char c = board[x][y];
        board[x][y] = '/';
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            if (dfs(board, word, x + dx[i], y + dy[i], k + 1)) return true;
        }
        // 因为我们是从各个点开始的，像迷宫那样从一个点开始，其实就可以不用赋值回去，但是这种从各个点开始的需要赋值回去，否则会漏掉一些结果
        board[x][y] = c;
        return false;
    }
}
