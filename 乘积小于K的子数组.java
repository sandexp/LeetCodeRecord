class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums.length==0)
            return 0;
        if(k==0 || k==1)
            return 0;
        int left=0,right=0;
        int lastRight=0;
        int mul=1;
        int ans=0;
        while(right<=nums.length){
            while(mul>=k){
                mul=mul/nums[left];
                left++;
            }
            if(right==nums.length){
                ans+=getSum(left,right-1,lastRight-1);
                break;
            }
            if(mul*nums[right]>=k){
                ans+=getSum(left,right-1,lastRight-1);
                lastRight=right;
            }
            mul=mul*nums[right];
            right++;
        }
        return ans;
    }

    public int getSum(int start,int end,int lastEnd){
        if(end<start)
            return 0;
        long a=0;
        long b=0;
        if((end-start)%2==0)
            a=(end-start+2)/2*(end-start+1);
        else
            a=(end-start+1)/2*(end-start+2);
        if(!(lastEnd<start)){
            if((lastEnd-start+2)%2==0)
                b=(lastEnd-start+2)/2*(lastEnd-start+1);
            else
                b=(lastEnd-start+1)/2*(lastEnd-start+2);
        }
        return (int)(a-b);
    }
}