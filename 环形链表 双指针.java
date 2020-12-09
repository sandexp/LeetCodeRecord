/**
 * 双指针法
 * 由于存在环的原因
 * 假设一个指针跑的块，另一个指针跑的满，
 * 那么快慢指针一定存在套圈的问题，如果存在套圈，则存在有环。
 * 
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=fast){
            if(fast==null ||fast.next==null)
                return false;
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}