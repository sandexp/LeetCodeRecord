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
    public ListNode plusOne(ListNode head) {
        if(head==null)
            return null;
        List<ListNode> list=new ArrayList();
        list.add(new ListNode(0));
        while(head!=null){
            list.add(head);
            head=head.next;
        }
        int p=list.size()-1;
        int sign=1;
        list.get(0).next=list.get(1);
        while(list.get(p).val+sign>=10){
            list.get(p).val=list.get(p).val+sign-10;
            sign=1;
            p--;
        }
        if(p<=0){
            list.get(0).val++;
            return list.get(0);
        }else{
            list.get(p).val++;
            return list.get(1);
        }
    }
}