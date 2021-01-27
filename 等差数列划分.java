class Solution {
    // 贪心+双指针
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3)
            return 0;
        int st=0,ed=1,cnt=0;
        int delta=A[ed]-A[st];
        while(ed<A.length){
            if(A[ed]-A[ed-1]!=delta){
                if(ed-st>2)
                    cnt+=(ed-st-2)*(ed-st-1)/2;
                st=ed-1;
                delta=A[ed]-A[ed-1];
            }
            ed++;
        }
        if(ed-st>2)
            cnt+=(ed-st-2)*(ed-st-1)/2;
        return cnt;
    }
}