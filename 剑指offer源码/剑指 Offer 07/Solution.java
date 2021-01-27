package com.eh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Solution {
    HashMap<Integer, Integer> inmap = new HashMap<>();

    int[] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }
    public TreeNode recur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) return null;
        TreeNode node = new TreeNode(po[pre_root]);
        int i = inmap.get(po[pre_root]);
        node.left = recur(pre_root + 1, in_left, i - 1);
        node.right = recur(pre_root + i - in_left + 1,i + 1,in_right);
        return node;
    }
}