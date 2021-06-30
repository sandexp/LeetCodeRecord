class Solution {

    /**
        nums[i]和nums2[j]相比较
        若nums[i]=nums2[j],则dp[i][j]=dp[i-1][j-1]+1

        若不等, 则dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])        

        假设nums1[i],nums2[j] 最长不相交的线数量为
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if(nums2.length * nums1.length==0)
            return 0;
        int[][] dp=new int[nums1.length][nums2.length];
        dp[0][0]=nums2[0]==nums1[0]?1:0;

        for(int i=1;i<nums1.length;i++){
            int c=nums1[i]==nums2[0]?1:0;
            dp[i][0]=Math.max(dp[i-1][0],c);
        }

        for(int i=1;i<nums2.length;i++){
            int c=nums2[i]==nums1[0]?1:0;
            dp[0][i]=Math.max(dp[0][i-1],c);
        }

        for(int i=1;i<nums1.length;i++){
            for(int j=1;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[nums1.length-1][nums2.length-1];
    }
}