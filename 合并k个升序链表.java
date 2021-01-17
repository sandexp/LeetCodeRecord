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
// TODO 使用优先队列
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=new ListNode();
        ListNode ret=ans;
        while(true){
            int index=getMin(lists);
            if(index==-1)
                break;
            ans.next=new ListNode(lists[index].val);
            ans=ans.next;
            lists[index]=lists[index].next;
        }
        return ret.next;
    }

    public int getMin(ListNode[] list){
        int minu=10010;
        int index=-1;
        for(int i=0;i<list.length;i++){
            if(list[i]!=null && list[i].val<minu){
                minu=list[i].val;
                index=i;
            }
        }
        return index;
    }
}