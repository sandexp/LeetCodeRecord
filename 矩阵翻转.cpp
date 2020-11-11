#include <stdio.h>
#include <vector>
using namespace std;

vector<vector<int>> transpose(vector<vector<int>> &A){
    int org_row=A.size();
    int org_col=A[0].size();
    int ret_col=org_row;
    int ret_row=org_col;
    // 矩阵翻转
    vector<vector<int>> ret;
    vector<int> tmp;
    for (size_t i = 0; i < ret_row; i++){
        tmp.clear();
        for (size_t j = 0; j < ret_col; j++){
            tmp.push_back(A[j][i]);
        }
        ret.push_back(tmp);
    }
    return ret;
}

void printResult(vector<vector<int>> &A){
    for (size_t i = 0; i < A.size(); i++){
        for (size_t j = 0; j < A[i].size(); j++){
            printf("%d ",A[i][j]);
        }
        printf("\n");
    }
    
}

vector<int> toVector(int* arr,int length){
    vector<int> res;
    int p=0;
    while (p<length){
        res.push_back(*(arr+p));
        p++;
    }
    return res;
}

int main(int argc, const char** argv) {

    int arr1[3]={1,2,3};
    int arr2[3]={4,5,6};
    int arr3[3]={7,8,9};
    vector<vector<int>> org;
    org.push_back(toVector(arr1,3));
    org.push_back(toVector(arr2,3));
    org.push_back(toVector(arr3,3));
    printResult(org);
    vector<vector<int>> res=transpose(org);
    printResult(res);
    return 0;
}
