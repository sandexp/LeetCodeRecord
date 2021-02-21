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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        List<ListNode> list=new ArrayList();
        list.add(new ListNode());
        while(list1!=null){
            list.add(list1);
            list1=list1.next;
        }
        list.get(a).next=list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=list.get(b+2);
        return list.get(1);
    }
}