package com.eh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode reverseHead = new ListNode(0);
        ListNode cur = head;//遍历指针  遍历原始链表
        int size = 0;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
            size++;
        }
        int[] result = new int[size];
        cur = reverseHead.next;
        int index = 0;
        while (cur != null) {
            result[index] = cur.val;
            cur = cur.next;
            index++;
        }
        return result;
    }
}