class Solution {
    public int jump(int[] nums) {
        if(nums==null)
            return 0;
        if(nums.length==1)
            return 0;
        int[] dp=new int[nums.length];
        dp[0]=0;
        for(int i=1;i<dp.length;i++)
            dp[i]=0x7fffffff;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<=Math.min(nums.length-1,i+nums[i]);j++)
                dp[j]=Math.min(dp[i]+1,dp[j]);
        }
        return dp[dp.length-1];
    }
}