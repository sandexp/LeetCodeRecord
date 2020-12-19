class Solution {
    public int firstMissingPositive(int[] nums) {
        int tmp=0,cnt=0;
        for(int i=1;i<=nums.length;i++){
            cnt=0;
            while(nums[i-1]>=1 && nums[i-1]<=nums.length && nums[i-1]!=i){
                tmp=nums[nums[i-1]-1];
                nums[nums[i-1]-1]=nums[i-1];
                nums[i-1]=tmp;
                cnt++;
                if(cnt>nums.length)
                    break;
            }
        }
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]!=i)
                return i;
        }
        return nums.length+1;
    }
}