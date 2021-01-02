class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1)
            return nums;
        Comparator<Integer> cmp=new Comparator<Integer>(){
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };
        int[] ans=new int[nums.length-k+1];
        PriorityQueue<Integer> queue=new PriorityQueue(cmp);
        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }
        ans[0]=queue.peek();
        int p=1;
        for(int i=k;i<nums.length;i++){
            queue.remove(nums[i-k]);
            queue.add(nums[i]);
            ans[p]=queue.peek();
            p++;
        }
        return ans;
    }
}