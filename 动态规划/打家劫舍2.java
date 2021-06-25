class Solution {

    /**
    循环数组 +
    先确定状态转移方程
        dp[i]=max(dp[i-2]+nums[i],dp[i-1])
    确定首个被偷的
    去掉最后一个元素, 转换成打家劫舍1
     */
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int[] dp=new int[nums.length];
        return Math.max(robMax(dp,nums,0,dp.length-2),robMax(dp,nums,1,dp.length-1));
    }

    public int robMax(int[] dp,int[] nums, int first,int last){
        dp[first]=nums[first];
        dp[first+1]=Math.max(nums[first],nums[first+1]);
        for(int i=first+2;i<= last;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[last];
    }
}