/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;
        ListNode ans=new ListNode();
        ListNode res=ans;
        int sign=0;
        while(l1!=null && l2!=null){
            ans.next=new ListNode((l1.val+l2.val+sign)%10);
            sign=(l2.val+l1.val+sign)/10;
            l1=l1.next;
            l2=l2.next;
            ans=ans.next;
        }
        while(l1!=null){
            ans.next=new ListNode((l1.val+sign)%10);
            sign=(l1.val+sign)/10;
            l1=l1.next;
            ans=ans.next;
        }
        while(l2!=null){
            ans.next=new ListNode((l2.val+sign)%10);
            sign=(l2.val+sign)/10;
            l2=l2.next;
            ans=ans.next;
        }
        if(sign!=0)
            ans.next=new ListNode(sign);
        return res.next;
    }
}