/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
   说明：每次只能向下或者向右移动一步。
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null)
            return 0;
        int ans=0x7fffffff;
        int[][] dp=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for(int x=0;x<dp.length;x++){
            for(int y=0;y<dp[0].length;y++){
                if(x==0 && y==0){
                    continue;
                }else if(x==0){
                    dp[x][y]=dp[x][y-1]+grid[x][y];
                }else if(y==0){
                    dp[x][y]=dp[x-1][y]+grid[x][y];
                }else{
                    dp[x][y]=Math.min(dp[x-1][y],dp[x][y-1])+grid[x][y];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

}