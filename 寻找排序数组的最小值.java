class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int p=0,ans=-1;
        while(p<nums.length-1){
            if(nums[p+1]<nums[p])
                return nums[p+1];
            p++;
        }
        return nums[0];
    }
}