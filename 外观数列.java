class Solution {
    public String countAndSay(int n) {
        if(n==0)
            return "";
        if(n==1)
            return "1";
        String[] dp=new String[n];
        dp[0]="1";
        for(int i=1;i<n;i++){
            StringBuffer sb=new StringBuffer();
            int st=0,ed=0;
            while(ed<dp[i-1].length()){
                if(dp[i-1].charAt(ed)!=dp[i-1].charAt(st)){
                    sb.append(ed-st);
                    sb.append(dp[i-1].charAt(st));
                    st=ed;
                }
                ed++;
                if(ed>=dp[i-1].length()){
                    sb.append(ed-st);
                    sb.append(dp[i-1].charAt(st));
                }

            }
            dp[i]=sb.toString();
        }
        return dp[n-1];
    }
}