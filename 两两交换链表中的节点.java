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
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        List<ListNode> list=new ArrayList();
        while(head!=null){
            list.add(head);
            head=head.next;
        }
        if(list.size()<2)
            return list.get(0);
        // 2k+1 --> 2k -->2(k+1)+1 --> 2(k+1)
        for(int i=0;i<list.size()/2;i++){
            if(2*i+1<list.size())
                list.get(2*i+1).next=list.get(2*i);
            if(2*(i+1)+1<list.size())
                list.get(2*i).next=list.get(2*(i+1)+1);
            else if(2*(i+1)<list.size())
                list.get(2*i).next=list.get(2*(i+1));
            else
                list.get(2*i).next=null;
        }
        return list.get(1);
    }
}