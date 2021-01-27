class Solution {

    public int numSquares(int n) {
        if(n<3)
            return n;
        int[] dp=new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=0;i<4;i++)
            dp[i]=i;
        int end=(int)Math.sqrt(n)+1;
        int[] arr=new int[end];
        for(int i=0;i<end;i++)
            arr[i]=i*i;
        for(int i=1;i<=n;i++){
            for(int j=1;j<end;j++){
                if(i<arr[j])
                    break;
                 dp[i] = Math.min(dp[i], dp[i - arr[j]]+ 1);
            }
        }
        return dp[n];   
    }
}