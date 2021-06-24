/**
    字符串处理方法, 设置两个指针i,j 作为读写指针,解决每个状态位的决策

    对于第i,j个问题的求解, 他可能由第i-1,j或者i,j-1 i-1,j-1个元素不同而进行操作
    也有可能时i-1,j-1相同直接转换而来
 */
class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()* word2.length()==0)
            return word2.length()+word1.length();

        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++)
            dp[i][0]=i;

        for(int i=0;i<=word2.length();i++)
            dp[0][i]=i;

        for(int i=1;i<= word1.length();i++){
            for(int j=1;j<= word2.length();j++){
                // 根据上一个状态的比较确定当前值
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]+1),dp[i-1][j]+1);
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1]+1,dp[i][j-1]+1),dp[i-1][j]+1);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}