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
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;
        List<ListNode> list=new ArrayList();
        while(head!=null){
            list.add(head);
            head=head.next;
        }
        int tmp=0;
        for(int i=1;i<list.size();i++){
            for(int j=i;j>0;j--){
                if(list.get(j).val<list.get(j-1).val){
                    tmp=list.get(j).val;
                    list.get(j).val=list.get(j-1).val;
                    list.get(j-1).val=tmp;
                }
            }
        }
        for(int i=1;i<list.size();i++)
            list.get(i-1).next=list.get(i);
        list.get(list.size()-1).next=null;
        return list.get(0);
    }
}