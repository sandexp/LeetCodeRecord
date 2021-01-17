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
// 一边扫描
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        int p1=0;
        int p2=0;
        ListNode l1=head;
        ListNode l2=head;
        ListNode ans=head;
        ListNode tmp=head;
        while(true){
            if(p1<n){
                if(l1.next==null)
                    return head.next;
                p1++;
                l1=l1.next;
            }else{
                p1++;
                p2++;
                if(l1.next==null){
                    tmp=l2;
                    break;
                }
                l1=l1.next;
                l2=l2.next;
            }
        }
        tmp.next=tmp.next.next;
        return ans;
    }
}