class Solution {
    public int trap(int[] height) {
        if(height==null || height.length<3)
            return 0;
        int[] front=new int[height.length];
        int[] back=new int[height.length];
        int maxf=-1,maxb=-1;
        front[height.length-1]=height[height.length-1];
        back[0]=height[0];
        for(int i=1;i<height.length;i++)
            back[i]=Math.max(back[i-1],height[i]);
        for(int i=height.length-2;i>=0;i--)
            front[i]=Math.max(front[i+1],height[i]);
        int ans=0;
        for(int i=0;i<height.length;i++){
            if(Math.min(front[i],back[i])>height[i])
               ans+=Math.min(front[i],back[i])-height[i]; 
        }
        return ans;
    }
}