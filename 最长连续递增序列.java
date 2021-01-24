class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<2)
            return nums.length;
        int maxn=-1;
        int p1=0,p2=0;
        while(p2<nums.length-1){
            if(nums[p2]>=nums[p2+1]){
                if(p2-p1+1>maxn)
                    maxn=p2-p1+1;
                p2++;
                p1=p2;
            }else{
                p2++;
            }
        }
        if(p2-p1+1>maxn)
            maxn=p2-p1+1;
        return maxn;
    }
}