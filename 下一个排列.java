class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==0 || nums.length==1 || nums==null)
            return;
        int pos=nums.length-1;
        int index1=0,index2=0,ans=101,tmp=0;
        while(pos>0){
            if(nums[pos]<=nums[pos-1]){
                pos--;
                index1=pos-1;
            }else{
                index1=pos-1;
                for(int i=pos;i<nums.length;i++){
                    if(nums[i]<=nums[index1])
                        continue;
                    if(nums[i]-nums[index1]<ans){
                        ans=nums[i]-nums[index1];
                        index2=i;
                    }
                }
                tmp=nums[index1];
                nums[index1]=nums[index2];
                nums[index2]=tmp;
                break;
            }
        }
        for(int i=index1+1;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    tmp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=tmp;
                }
            }
        }
    }
}