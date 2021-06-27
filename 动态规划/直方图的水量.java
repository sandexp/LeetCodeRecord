class Solution {
    /**
        蓄水量就是从左向右的蓄水量和从右向左蓄水量的交集
        设left[i]为0-i 区间内与之间最大值的差
        同理right[i] 
    */
    public int trap(int[] height) {
        if(height==null)
            return 0;
        if(height.length<3)
            return 0;
        int[] left=new int[height.length];
        int[] right=new int[height.length];
        left[0]=0;
        right[height.length-1]=0;
        int max=0;
        for(int i=0;i<height.length;i++){
            if(height[i]<max)
                left[i]=max-height[i];

            if(height[i]>max)
                max=height[i];
        }
        max=0;
        for(int i=height.length-1;i>=0;i--){
            if(height[i]<max)
                right[i]=max-height[i];

            if(height[i]>max)
                max=height[i];
        }
        int cnt=0;
        for(int i=0;i<height.length;i++){
            cnt+=Math.min(left[i],right[i]);
        }

        return cnt;
    }
}