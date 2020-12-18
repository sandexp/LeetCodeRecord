class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null)
            return null;
        int prefix=1,suffix=1;
        int[] ans=new int[nums.length];
        ans[nums.length-1]=suffix;
        for(int i=nums.length-2;i>=0;i--){
            ans[i]=nums[i+1]*suffix;
            suffix=ans[i];
        }
        for(int i=1;i<nums.length;i++){
            prefix=prefix*nums[i-1];
            ans[i]=ans[i]*prefix;
        }
        return ans;
    }
}