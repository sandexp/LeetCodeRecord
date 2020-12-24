class Solution {
    // 前缀和
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || s<=0 || nums.length==0)
            return 0;
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++)
            sum[i]=nums[i]+sum[i-1];
        if(sum[nums.length-1]<s)
            return 0;
        if(sum[nums.length-1]==s)
            return nums.length;
        int ans=999999;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(sum[j]-sum[i]+nums[i]>=s && (j-i+1)<ans)
                    ans=j-i+1;
            }
        }
        return ans;
    }
}