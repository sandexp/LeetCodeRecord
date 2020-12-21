class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums==null)
            return null;
        List<Integer> ans=new ArrayList();
        int a=-1000000001;
        int b=1000000001;
        int counta=0,countb=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==a){
                counta++;
            }else if(nums[i]==b){
                countb++;
            }else{
                if(counta==0){
                    a=nums[i];
                    counta++;
                    continue;
                }
                if(countb==0){
                    b=nums[i];
                    countb++;
                    continue;
                }
                counta--;
                countb--;
            }
        }
        countb=0;
        counta=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==a)
                counta++;
            if(nums[i]==b)
                countb++;
        }
        if(counta>nums.length/3)
            ans.add(a);
        if(countb>nums.length/3)
            ans.add(b);
        return ans;
    }
}