class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return nums[0]+nums[1];
        int last=-1,cur=-1,p=0,ans=0;
        while(p<nums.length){
            if(nums[p]==0){
                last=cur;
                cur=p;
                if(cur-last-1>ans)
                    ans=cur-last-1;
            }
            p++;
        }
        if(nums.length-cur-1>ans)
            ans=nums.length-cur-1;
        return ans;
    }
}