class Solution {

    /**
    考虑两个满足的字符串连接
    s1,s2
    s1,s2满足条件并且连续,所以长度总和为s1+s2
    
    设dp[j]是以j结尾为字符串合格有效长度的子串,则s[j]=)
    如果s[j-1]是(, 那么j-1,j构成s2, 所以只需要合并s1即可
    所以
        dp[j]=dp[j-2]+2

    如果s[j-1]则,dp[j-1]可以扩展到dp[j]位
        dp[j]=dp[j-1-dp[j-1]]+2
    在考虑与前段合并
        dp[j]=dp[j-1]+2+dp[j-1-dp[j-1]-1]

     */
    public int longestValidParentheses(String s) {
        if(s.equals("") || s.length()<2)
            return 0;

        int[] dp=new int[s.length()];
        int maxn=-1;
        for(int i=1;i<dp.length;i++){

            if(s.charAt(i)==')'){
                if(s.charAt(i-1)==')'){
                    // 考虑对i-1的扩展,当且仅当 i-dp[i-1]-1 为 ( 的情况下, 才能进行扩展dp[i-1]+2
                    // 同时需要对dp[i-dp[i-1]-1]之前的部分进行合并dp[i-dp[i-1]-2]
                    // 例如()(())
                    if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='('){
                        dp[i]=dp[i-1]+2+((i-dp[i - 1])>=2?dp[i-dp[i-1]-2]:0);
                        
                    }
                }else{
                    // 仅考虑单括号的扩展 
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                }
            }
            maxn=Math.max(dp[i],maxn);
        }
        return maxn;
    }
}