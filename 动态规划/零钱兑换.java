class Solution {
    /**
    完全背包问题

    假设dp[i]是拿到i 金额最少硬币数量

    dp[0] -> dp[i-1]已经计算出来了
    dp[i]=dp[i-coins[j]]+1

    所以求最小值, 就是所有能够拿到S的最小值
    即dp[i]=min(dp[i],dp[i-coins[j]]+1)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        for(int i=0;i<dp.length;i++)
            dp[i]=Integer.MAX_VALUE-1;
        
        dp[0]=0;

        for(int i=1; i<= amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]<0)
                    continue;
                
                dp[i]=Math.min(dp[i-coins[j]]+1,dp[i]);
            }
        }
        // for(int i=0;i<=amount;i++)
        //     System.out.println("I= "+i+"\tValue= "+dp[i]);
        return dp[amount]==Integer.MAX_VALUE-1?-1:dp[amount];
    }
}