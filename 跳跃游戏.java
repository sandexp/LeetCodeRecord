// 反向动态规划
class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null)
            return false;
        if(nums.length==1)
            return true;
        boolean[] dp=new boolean[nums.length];
        dp[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--){
            int p=1;
            while(p<=nums[i] && i+p<nums.length){
                dp[i]=dp[i+p] || dp[i];
                if(dp[i])
                    break;
                p++;
            }
        }
        return dp[0];
    }
}