class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int x=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int y=nums[nums.length-1]*nums[0]*nums[1];
        return x>y?x:y;
    }
}