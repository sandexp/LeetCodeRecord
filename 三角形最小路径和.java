class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null)
            return 0;
        int layers=triangle.size();
        int scale=(1+layers)*layers/2;
        int[] dp=new int[scale+1];
        dp[1]=triangle.get(0).get(0);
        if(triangle.size()==1)
            return dp[1];
        int ans=0x7fffffff;
        for(int layer=2;layer<=layers;layer++){
            List<Integer> last=triangle.get(layer-2);
            List<Integer> current=triangle.get(layer-1);
            for(int i=0;i<current.size();i++){
                int index=layer*(layer-1)/2+i+1;
                if(i==0){
                    dp[index]=dp[(layer-1)*(layer-2)/2+1]+current.get(i);
                }else if(i==current.size()-1){
                    dp[index]=current.get(i)+dp[(layer-1)*layer/2];
                }else{
                    dp[index]=Math.min(dp[(layer-2)*(layer-1)/2+i],dp[(layer-2)*(layer-1)/2+i+1])+current.get(i);
                }
                if(layer==layers && dp[index]<ans){
                    ans=dp[index];
                }
            }
        }
        return ans;
    }
}