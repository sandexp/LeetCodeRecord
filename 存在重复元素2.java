class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0 || nums.length==1)
            return false;
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null &&  Math.abs(map.get(nums[i])-i)<=k)
                return true;   
            map.put(nums[i],i);
        }
        return false;
    }
}