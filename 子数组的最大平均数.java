class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int[] prefix=new int[nums.length+1];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++)
            prefix[i]=prefix[i-1]+nums[i];
        prefix[nums.length]=prefix[nums.length-1];
        int start=0,maxn=-9999999;
        while(start+k<=nums.length){
            if(prefix[start+k-1]-prefix[start]+nums[start]>maxn){
                maxn=prefix[start+k-1]-prefix[start]+nums[start];
            }
            start++;
        }
        return (double)maxn/k;
    }
}