class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] counter=new int[110];
        for(int[] tmp:dominoes){
            int hash=Math.min(tmp[0],tmp[1])*10+Math.max(tmp[0],tmp[1]);
            counter[hash]++;
        }
        int ans=0;
        for(int i=0;i<110;i++){
            if(counter[i]>1)
                ans+=counter[i]*(counter[i]-1)/2;
        }
        return ans;
    }
}