class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<3)
            return nums.length;
        int start=0,end=0,ans=0;
        int TRAP=0x7fffffff;
        while(end<nums.length){
            if(nums[end]==nums[start] && end-start>=2){
                nums[end]=TRAP;
            }else if(nums[end]!=nums[start]){
                if(end-start>=2)
                    ans+=2;
                else
                    ans+=end-start;
                start=end;
            }
            end++;
        }
        if(end-start>2)
            ans+=2;
        else
            ans+=end-start;
        Arrays.sort(nums);
        return ans;
    }   
}