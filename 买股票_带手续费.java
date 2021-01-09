class Solution {

    public int maxProfit(int[] prices, int fee) {
        if(prices.length==0 || prices.length==1)
            return 0;
        int buy=prices[0]+fee;
        int ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]+fee<buy){
                buy=prices[i]+fee;
            }else if(prices[i]>buy){
                ans+=prices[i]-buy;
                buy=prices[i];
            }
        }
        return ans;
    }
}