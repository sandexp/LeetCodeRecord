class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums==null)
            return 0;
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0)
                ans+=nums[i];
        }
        return ans;
    }
}