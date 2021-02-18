/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack();
        Stack<Integer> s2=new Stack();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        ListNode l3=null;
        int sign=0;
        while(!s1.empty() && !s2.empty()){
            ListNode tmp=new ListNode((s1.peek()+s2.peek()+sign)%10);
            sign=(s1.pop()+s2.pop()+sign)/10;
            tmp.next=l3;
            l3=tmp;
        }
        while(!s1.empty()){
            ListNode tmp=new ListNode((s1.peek()+sign)%10);
            sign=(s1.pop()+sign)/10;
            tmp.next=l3;
            l3=tmp;
        }
        while(!s2.empty()){
            ListNode tmp=new ListNode((s2.peek()+sign)%10);
            sign=(s2.pop()+sign)/10;
            tmp.next=l3;
            l3=tmp;
        }
        if(sign>0){
            ListNode tmp=new ListNode(sign);
            tmp.next=l3;
            l3=tmp;
        }
        return l3;
    }
}