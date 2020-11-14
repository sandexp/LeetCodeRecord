#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
    // 与v2相同的部分采用插入排序,其他元素单独排序
    map<int,int> index;
    for (size_t i = 0; i < arr2.size(); i++){
        index[arr2[i]]=i+1;
    }
    int same_cnt=0,tmp=0;
    int ans1[arr1.size()];
    vector<int> ans2;
    for (size_t i = 0; i < arr1.size(); i++){
        if(index[arr1[i]]==0){
            ans2.push_back(arr1[i]);
        }else{
            if(same_cnt==0){
                ans1[0]=arr1[i];
            } else {
                int p=same_cnt;
                ans1[same_cnt]=arr1[i];
                while (p>0){
                    if(index[ans1[p]]<index[ans1[p-1]]){
                        tmp=ans1[p];
                        ans1[p]=ans1[p-1];
                        ans1[p-1]=tmp;
                    }
                    p--;
                }
            }
            same_cnt++;
        }
    }
    sort(ans2.begin(),ans2.end());
    vector<int> ans;
    for (size_t i = 0; i < same_cnt; i++)
        ans.push_back(ans1[i]);
    for (size_t i = 0; i < ans2.size(); i++)
        ans.push_back(ans2[i]);
    return ans;
}

vector<int> toVector(int* arr,int size){
    int p=0;
    vector<int> ans;
    while (p<size){
        ans.push_back(*(arr+p));
        p++;
    }
    return ans;
}

void printVector(vector<int> v){
    for (size_t i = 0; i < v.size(); i++){
        cout<<v[i]<<" ";
    }
    cout<<"\n";
}

int main(int argc, char const *argv[]){

    int arr1[11]={2,3,1,3,2,4,6,7,9,2,19}; 
    int arr2[6]={2,1,4,3,9,6}; 
    vector<int> v1=toVector(arr1,11);
    vector<int> v2=toVector(arr2,6);
    vector<int> ans=relativeSortArray(v1,v2);
    printVector(ans);
    return 0;
}
