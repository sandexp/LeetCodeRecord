// 暴力法需要优化
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==1)
            return;
        int tmp=0,pos=0,last=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]==0){
                pos=i;
                while(pos<last){
                    tmp=nums[pos];
                    nums[pos]=nums[pos+1];
                    nums[pos+1]=tmp;
                    pos++;
                }
                last--;
            }
        }
    }
}