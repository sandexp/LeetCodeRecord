class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] prefix=new int[cardPoints.length];
        prefix[0]=cardPoints[0];
        for(int i=1;i<cardPoints.length;i++)
            prefix[i]=prefix[i-1]+cardPoints[i];
        if(k==cardPoints.length)
            return prefix[prefix.length-1];
        int ans=-1,front=0;
        while(front<=k){
            int tmp=prefix[cardPoints.length-1]-(prefix[cardPoints.length-1-(k-front)]-prefix[front]+cardPoints[front]);
            if(tmp>ans)
                ans=tmp;
            front++;
        }
        return ans;
    }
}