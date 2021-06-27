class Solution {
    
    /**
    
    对于一个序列1,2,3... n
    如果以i为根节点
    左边就是1,2...i-1 共计i-1个元素
    右边就是i+1,i+2... n共计 n-(i-1)-1个元素

    可以划分为左右两部分进行求解
    并将结果相乘

     */
    public int numTrees(int n) {
        if(n==1 || n==0)
            return 1;
        if(n==2)
            return 2;
        int[] dp=new int[n+1];

        dp[1]=1;
        dp[0]=1;
        dp[2]=2;

        for(int i=3;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}