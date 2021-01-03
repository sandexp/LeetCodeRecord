/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode backup=new ListNode();
        ListNode current=new ListNode();
        ListNode second=current;
        ListNode first=backup;
        while(head!=null){
            if(head.val>=x){
                current.next=new ListNode(head.val);
                current=current.next;
            }else{
                backup.next=new ListNode(head.val);
                backup=backup.next;
            }
            head=head.next;
        }
        backup.next=second.next;
        return first.next;
    }
}