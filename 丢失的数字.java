class Solution {
    public int missingNumber(int[] nums) {
        if(nums==null)
            return 0;
        if(nums.length==1)
            return nums[0]==0?1:0;
        int tmp=0;
        for(int i=0;i<nums.length;i++){
            int p=i;
            while(nums[p]>=0 && nums[p]<=nums.length-1 && nums[p]!=p && nums[p]<nums.length){
                tmp=nums[nums[p]];
                nums[nums[p]]=nums[p];
                nums[p]=tmp;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i)
                return i;
        }
        return nums.length;
    }
}