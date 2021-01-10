/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return null;
        
        ListNode tag=new ListNode();
        ListNode first=new ListNode();
        ListNode last=new ListNode();
        ListNode ans=tag;
        tag.next=head;

        ListNode curLast=new ListNode();
        ListNode curFirst=null;
        int cnt=0;
        while(tag!=null){
            if(cnt==m-1)
                curLast=tag;
            if(cnt==n+1)
                curFirst=tag;
            if(cnt==m){
                first=new ListNode(tag.val);
                last=first;
            }
            if(cnt>m && cnt<=n){
                ListNode tmp=new ListNode(tag.val);
                tmp.next=first;
                first=tmp;
            }
            cnt++;
            tag=tag.next;
        }
        curLast.next=first;
        last.next=curFirst;
        return ans.next;
    }
}