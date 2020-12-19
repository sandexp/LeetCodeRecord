class Solution {
    /**
        标记置换法
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null)
            return null;
        int tmp=0;
        for(int i=0;i<nums.length;i++){
            while(nums[i]>=1 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i] && nums[i]!=i+1){
                tmp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=tmp;
            }
        }
        List<Integer> ans=new ArrayList();
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]!=i){
                ans.add(i);
            }
        }
        return ans;
    }
}