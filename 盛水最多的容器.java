class Solution {
    public int maxArea(int[] height) {
        if(height==null)
            return 0;
        int ans=-1;
        int pa=0, pb=height.length-1;
        int sa=0,sb=0,tmp=0;
        while(pa<pb){
            if(height[pa]<sa){
                pa++;
                continue;
            }
            if(height[pb]<sb){
                pb--;
                continue;
            }
            if(height[pb]>height[pa]){
                sa=height[pa];
                if(height[pa]*(pb-pa)>ans){
                    tmp=height[pa]>height[pb]?height[pb]:height[pa];
                    ans=tmp*(pb-pa);
                }
                pa++;
            }else{
                sb=height[pb];
                if(height[pb]*(pb-pa)>ans){
                    tmp=height[pa]>height[pb]?height[pb]:height[pa];
                    ans=tmp*(pb-pa);
                }
                pb--;
            }
        }
        return ans;
    }
}