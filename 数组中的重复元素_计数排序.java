class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        if(nums==null)
            return null;
        List<Integer> ans= new ArrayList();
        int[] status=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            if(status[nums[i]]>0){
                ans.add(nums[i]);
                continue;
            }
            status[nums[i]]++;
        }
        return ans;
    }
}