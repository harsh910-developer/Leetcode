/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> a = new ArrayDeque<>(), b = new ArrayDeque<>();
        for(;l1 != null; l1 = l1.next) a.push(l1.val);
        for(;l2 != null; l2 = l2.next) b.push(l2.val);
        ListNode res = null;
        int carry = 0;
        while(!a.isEmpty() || !b.isEmpty() || carry > 0){
            int sum = carry + (a.isEmpty() ? 0 : a.pop()) + (b.isEmpty() ? 0 : b.pop());
            ListNode newNode = new ListNode(sum%10);
            newNode.next = res;
            res = newNode;
            carry = sum / 10;
        }
        return res;
    }
}