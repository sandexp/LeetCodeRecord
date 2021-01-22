class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp=new int[11];
        dp[1]=10;
        dp[0]=1;
        int mul=81,p=2,add=8;
        while(p<11){
            dp[p]=dp[p-1]+mul;
            mul*=add;
            add--;
            p++;
        }
        if(n>10)
            return dp[10];
        else
            return dp[n];
    }
}