class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length<3)
            return 0;
        Arrays.sort(nums);
        int ans=0;
        for(int i=1;i<nums.length-1;i++){
            int left=i-1;
            int direct=0;
            while(left>=0){
                int right=i+1;
                while(right<nums.length){
                    if(nums[left]+nums[i]>nums[right]){
                        ans++;
                        right++;
                    }else{
                        break;
                    }
                }
                left--;
            }
        }
        return ans;
    }
}