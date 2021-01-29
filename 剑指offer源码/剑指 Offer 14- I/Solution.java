package com.eh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Solution {
    public int cuttingRope(int n) {
        if (n == 2 || n == 3) return n - 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 0; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }
}
