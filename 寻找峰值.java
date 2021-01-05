class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 0;
        if(nums.length==2)
            return nums[0]>nums[1]?0:1;
        int pos=1;
        while(pos<nums.length-1){
            if(nums[pos-1]<nums[pos] && nums[pos]>nums[pos+1])
                return pos;
            pos++;
        }
        if(nums[0]>nums[1])
            return 0;
        if(nums[nums.length-1]>nums[nums.length-2])
            return nums.length-1;
        return -1;
    }
}