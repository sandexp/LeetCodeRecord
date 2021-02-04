
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
    public ListNode sortList(ListNode head) {
        List<Integer> list=new ArrayList();
        ListNode tmp=head;
        ListNode ans=head;
        while(tmp!=null){
            list.add(tmp.val);
            tmp=tmp.next;
        }
        Collections.sort(list);
        int p=0;
        while(head!=null){
            head.val=list.get(p);
            p++;
            head=head.next;
        }
        return ans;
    }
}