class Solution {
    /**
        将L1记为结果链表，将L2插入到L1中
        设置指针p1指向L1的节点
            指针p2指向L2的节点
        如果p2指向的值小于等于p1指向的值,则将p2插入到p1的后边，插入完毕p2指针向右移动
        如果不满足这样的关系,则将p1的指针向右移动一位
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode();
        ListNode tmp=ans;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tmp.next=new ListNode(l1.val);
                l1=l1.next;
            }else{
                tmp.next=new ListNode(l2.val);
                l2=l2.next;
            }
            tmp=tmp.next;
        }
        while(l1!=null){
            tmp.next=new ListNode(l1.val);
            l1=l1.next;
            tmp=tmp.next;
        }
        while(l2!=null){
            tmp.next=new ListNode(l2.val);
            l2=l2.next;
            tmp=tmp.next;
        }
        return ans.next;
    }
}