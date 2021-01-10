class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0)
            return new ArrayList<String>();
        int start=0,end=0;
        List<String> ans=new ArrayList();
        while(end<nums.length){
            if((nums[end]-nums[start])!=(end-start)){
                if(nums[start]==nums[end-1]){
                    ans.add(String.valueOf(nums[start]));
                }else{
                    ans.add(String.valueOf(nums[start]+"->"+nums[end-1]));
                }
                start=end;
            }else{
                end++;
            }
        }
        if(start==nums.length-1){
            ans.add(String.valueOf(nums[start]));
        }else{
            ans.add(String.valueOf(nums[start]+"->"+nums[nums.length-1]));
        }
        return ans;
    }
}