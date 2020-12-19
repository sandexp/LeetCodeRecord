class Solution {
    public int dominantIndex(int[] nums) {
        if(nums==null)
            return -1;
        if(nums.length==1)
            return 0;
        int minu=0xffffffff;
        int index=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>minu){
                minu=nums[i];
                index=i;
            }
        }
        Arrays.sort(nums);
        if(nums[nums.length-1]>=nums[nums.length-2]*2)
            return index;
        else
            return -1;
    }
}