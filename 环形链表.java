 // 注意可以有两个节点值相等
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set=new HashSet();
        while(head!=null){
            if(!set.add(head)){
                return true;
            }
            set.add(head);
            head=head.next;
        }
        return false;
    }
}