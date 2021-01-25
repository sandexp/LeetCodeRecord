/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	// O(1)空间复杂度算法
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode ans=head;
        int cf=0,cs=0,dn=0;
        if(fast==null)
            return null;
        while(fast!=null){
            if(fast.next==null || slow==null)
                return null;
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                while(ans!=slow){
                    ans=ans.next;
                    slow=slow.next;
                }
                return ans;
            }
        }
        return null;
    }
}