class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0 || obstacleGrid==null)
            return 0;
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0]=1;
        for(int x=0;x<obstacleGrid.length;x++){
            for(int y=0;y<obstacleGrid[0].length;y++){
                if(obstacleGrid[x][y]==1)
                    dp[x][y]=0;
                else{
                    if(x>0)
                        dp[x][y]+=dp[x-1][y];
                    if(y>0)
                        dp[x][y]+=dp[x][y-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}