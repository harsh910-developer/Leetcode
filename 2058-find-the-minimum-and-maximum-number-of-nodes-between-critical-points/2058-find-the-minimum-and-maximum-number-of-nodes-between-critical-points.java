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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1, -1};

        if(head == null || head.next == null || head.next.next == null){
            return result;
        }
        ListNode prev = head;
        ListNode curr = head.next;

        int index = 2;

        int firstCritical = -1;
        int endCritical = -1;

        int minDistance = Integer.MAX_VALUE;
        while(curr.next != null){
            int prevValue = prev.val;
            int currValue = curr.val;
            int nextValue = curr.next.val;

            boolean isCritical = ((prevValue > currValue && currValue < nextValue) ||
                                (prevValue < currValue && currValue > nextValue));

            if(isCritical){
                if(firstCritical == -1){
                    firstCritical = index;
                }else{
                    minDistance = Math.min(minDistance, index - endCritical);
                }
                endCritical = index;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        if(firstCritical == endCritical){
            return result;
        }
        int maxDistance = endCritical - firstCritical;

        result[0] = minDistance;
        result[1] = maxDistance;

        return result;
    }
}