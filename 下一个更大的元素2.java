class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length==0)
            return new int[0];
        int[] ans=new int[nums.length];
        Arrays.fill(ans,-1);
        int st=0;
        while(st<nums.length){
            for(int i=st;i<st+nums.length;i++){
                if(nums[i%nums.length]>nums[st]){
                    ans[st]=nums[i%nums.length];
                    break;
                }
            }
            st++;
        }
        return ans;
    }
}