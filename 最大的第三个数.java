class Solution {
    public int thirdMax(int[] nums) {
        long first= -2147483649L;
        long second=-2147483650L;
        long third= -2147483651L;
        int tag=0;
        for(int i=0;i<nums.length;i++){
            if( nums[i]==first || nums[i]==second || nums[i]==third )
                continue;
            if(nums[i]>first){
                third=second;
                second=first;
                first=nums[i];
            }else if(nums[i]>second){
                third=second;
                second=nums[i];
            }else if(nums[i]>third){
                third=nums[i];
            }
        }
        if(third<-2147483648L)
            return (int)first;
        else
            return (int)third;
    }
}