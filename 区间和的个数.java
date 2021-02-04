class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length==0)
            return 0;
        long[] prefix=new long[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++)
            prefix[i]=prefix[i-1]+nums[i];
        int ans=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                long tmp=prefix[j]-prefix[i]+nums[i];
                if(tmp>=(long)lower && tmp<=(long)upper)
                    ans++;
            }
        }
        return ans;
    }   
}