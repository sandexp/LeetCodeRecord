class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return new int[]{-1,-1};
        int start=0,end=nums.length-1;
        boolean flag=false;
        while(start<=end){
            if(nums[start]==target && nums[end]==target){
                flag=true;
                break;
            }
            if(nums[start]> target || nums[end]<target)
                break;
            if(nums[start]<target)
                start++;
            if(nums[end]>target)
                end--;
        }
        if(flag)
            return new int[]{start,end};
        else
            return new int[]{-1,-1};
    }
}