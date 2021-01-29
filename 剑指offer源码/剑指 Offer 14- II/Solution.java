package com.eh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Solution {
   public int cuttingRope(int n) {
        long ans = 1;
        if(n == 2) return 1;
        else if(n == 3) return 2;
        else if(n == 4) return 4;
        while(true){
            if(n == 2) return (int) (ans * 2 % 1000000007);
            else if(n == 4) return (int) (ans * 4 % 1000000007);
            else if(n == 3) return (int) (ans * 3 % 1000000007);
            else{
                n -= 3;
                ans = ans * 3 % 1000000007;
            }
        }
    }
}
