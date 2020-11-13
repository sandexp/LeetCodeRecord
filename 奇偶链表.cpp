#include <iostream>
using namespace std;

struct ListNode{
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* oddEvenList(ListNode* head) {
    if(head==NULL)
        return NULL;
    int next=2;
    int cnt=0;
    ListNode* ans=head;
    // 交换后上一个节点
    ListNode* startNode=head;
    ListNode* lastNode=head;
    ListNode* tmpNode;
    // 交换后下一个节点
    ListNode* nextNode=head->next;
    while (head!=NULL){
        head=head->next;
        cnt++;
        if(cnt==next && head!=NULL){
            // 找到了奇链表的下一个节点
            // 修改指向
            tmpNode=nextNode;
            while (cnt>2){
                nextNode=nextNode->next;
                cnt--;
            }
            lastNode->next=head;
            nextNode->next=head->next;
            head->next=tmpNode;
            // 更新lastNode和nextNode
            lastNode=head;
            nextNode=head->next;
            next++;
            cnt=0;
        }
    }
    return ans;
}

void printList(ListNode* head){
    while (head!=NULL){
        cout<<head->val<<" ";
        head=head->next;
    }
    if(head==NULL)
        cout<<"NULL\n";
}

ListNode* toListNode(int* arr, int size){
    ListNode* head=new ListNode(*arr);
    ListNode* res=head;
    for (size_t i = 1; i < size; i++){
        head->next=new ListNode(*(arr+i));
        head=head->next;
    }
    head->next=NULL;
    return res;
}

int main(int argc, char const *argv[]){

    int arr[8]={1,2,3,4,5,6,7,8};
    ListNode* head=toListNode(arr,8);
    printList(head);
    
    ListNode* ans=oddEvenList(head);
    printList(head);
    return 0;
}
