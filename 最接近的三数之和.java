class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int mindistance=0x7fffffff;
        int pb=0,pc=0,sum=0,tmp=0,ans=0;
        for(int i=0;i<nums.length-2;i++){
            sum=target-nums[i];
            pb=i+1;
            pc=nums.length-1;
            while(pc>pb){
                if(nums[pc]+nums[pb]>sum)
                    tmp=nums[pc]+nums[pb]-sum;
                else
                    tmp=sum-nums[pc]-nums[pb];
                if(tmp<mindistance){
                    mindistance=tmp;
                    ans=nums[pb]+nums[pc]+nums[i];
                }
                if(nums[pc]+nums[pb]>sum){
                    pc--;
                } else if(nums[pc]+nums[pb]<sum){
                    pb++;
                }else{
                    return target;
                }
            }
        }
        return ans;
    }
}