class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums.length==1)
            return 1;
        Map<Integer,Integer> numbers=new HashMap();
        Set<Integer> set=new HashSet();
        Set<Integer> backup=new HashSet();
        int maxn=-1;
        for(int i=0;i<nums.length;i++){
            if(numbers.containsKey(nums[i]))
                numbers.put(nums[i],numbers.get(nums[i])+1);
            else
                numbers.put(nums[i],1);
            maxn=numbers.get(nums[i])>maxn?numbers.get(nums[i]):maxn;
        }
        
        for(Integer num:numbers.keySet()){
            if(numbers.get(num)==maxn){
                set.add(num);
                backup.add(num);
            }
        }

        int ans=nums.length;
        int pl=0,pr=nums.length-1;
        while(true){
            if(set.contains(nums[pl]) && set.contains(nums[pr]) && set.size()==1)
                break;
            if(set.contains(nums[pl]) && set.size()>1){
                set.remove(nums[pl]);
                pl++;
            }else if(!set.contains(nums[pl])){
                pl++;
            }
            if(set.contains(nums[pr]) && set.size()>1){
                set.remove(nums[pr]);
                pr--;
            }else if(!set.contains(nums[pr])){
                pr--;
            }
        }
        ans=Math.min(ans,pr-pl+1);

        pl=0;
        pr=nums.length-1;
        while(true){
            if(backup.contains(nums[pl]) && backup.contains(nums[pr]) && backup.size()==1)
                break;
            if(backup.contains(nums[pr]) && backup.size()>1){
                backup.remove(nums[pr]);
                pr--;
            }else if(!backup.contains(nums[pr])){
                pr--;
            }
            if(backup.contains(nums[pl]) && backup.size()>1){
                backup.remove(nums[pl]);
                pl++;
            }else if(!backup.contains(nums[pl])){
                pl++;
            }
        }
        ans=Math.min(ans,pr-pl+1);
        return ans;
    }
}