package com.eh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            map.put(n, (numWays(n - 1) + numWays(n - 2)) % 1000000007);
            return map.get(n);
        }
    }
}
