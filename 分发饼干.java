class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g==null || s==null)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int p1=0,p2=0,ans=0;
        while(p1<g.length && p2<s.length){
            if(s[p2]>=g[p1]){
                p1++;
                p2++;
                ans++;
            }else{
                p2++;
            }
        }
        return ans;
    }
}