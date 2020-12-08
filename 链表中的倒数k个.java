class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tmp=head;
        int count=1;
        while(tmp!=null){
            tmp=tmp.next;
            count++;
        }
        while(head!=null){
            count--;
            if(count==k)
                return head;
            head=head.next;
        }
        return null;
    }
}