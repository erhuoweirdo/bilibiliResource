public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        if (head.val == val) return head.next;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}
