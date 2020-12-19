class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null)
            return 0;
        if(prices.length==1)
            return 0;
        int bottom=-1,top=-1,p=0;
        int direct=-1;
        int ans=0;
        while(p<prices.length-1){
            if((prices[p+1]-prices[p])*direct<0){
                if(direct==-1){
                    direct=1;
                    bottom=p;
                }else{
                    direct=-1;
                    top=p;
                }
                if(bottom!=-1 && top!=-1){
                    ans+=prices[top]-prices[bottom];
                    top=-1;
                    bottom=-1;
                }
            }
            p++;
        }
        if(bottom!=-1 && top==-1 && direct==1)
            ans+=prices[prices.length-1]-prices[bottom];
        return ans;
    }
}