class Solution {

    
    /**
    
        dp[i][j]表示第i轮到j元素的方案总数
        则dp[i+1][k]=sum(dp[i][j])
        其中j,k为[j,k]元素
     */
    public int numWays(int n, int[][] relation, int k) {
        if(relation==null || relation.length==0)
            return 0;

        int[][] dp=new int[k+1][n];
        dp[0][0]=1;

        for(int i=1;i<=k;i++){
            for(int[] d:relation){
                dp[i][d[1]]+=dp[i-1][d[0]];
            }
        }
        return dp[k][n-1];
    }
}