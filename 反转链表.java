class Solution {
    public ListNode reverseList(ListNode head) {

        if(head==null)
            return null;
        ListNode nextNode=head.next;
        if(nextNode==null)
            return head;
        ListNode tmpNode=new ListNode(0);
        ListNode lastNode=new ListNode(0);
        ListNode tail=head;
        while(head!=null){
            if(nextNode==null){
                lastNode=tmpNode;
                tail.next=null;
                break;
            }
            tmpNode=nextNode;
            nextNode=nextNode.next;
            tmpNode.next=head;
            head=tmpNode;
        }
        return lastNode;
    }
}