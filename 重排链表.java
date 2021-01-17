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
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        List<ListNode> list=new ArrayList();
        while(head!=null){
            list.add(head);
            head=head.next;
        }
        int last=list.size()%2==0?list.size()/2:list.size()/2+1;
        for(int i=0;i<last;i++){
            list.get(i).next=list.get(list.size()-1-i);
            if(i+1<last)
                list.get(list.size()-1-i).next=list.get(i+1);
            else
                list.get(list.size()-1-i).next=null;
        }
    }
}