class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans=new int[n];
        int[] count=new int[n];
        for(int i=0;i<n-k;i++){
            ans[i]=i+1;
            count[i]++;
        }
        ans[n-k]=n;
        count[n-1]=1;
        int d=k-1;
        for(int i=n-k+1;i<n;i++){
            if(ans[i-1]-d<=n && ans[i-1]-d>=1 && count[ans[i-1]-d-1]==0)
                ans[i]=ans[i-1]-d;
            else if(ans[i-1]+d<=n && ans[i-1]+d>=1 && count[ans[i-1]+d-1]==0)
                ans[i]=ans[i-1]+d;
            count[ans[i]-1]++;
            d--;
        }
        return ans;
    }   
}