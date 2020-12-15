class Solution {
    
    List<List<Integer>> res= new ArrayList();
    List<Integer> ans=new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        dfs(0,nums);
        return res;
    }

    // 选择第n个数
    public void dfs(int index,int[] nums){
        if(index==nums.length){
            res.add(ans);
            for(Integer i:ans){
                System.out.print(i+" ");
            }
            System.out.print("\n");
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(ans.contains(nums[i])){
                continue;
            } 
            ans.add(nums[i]);
            dfs(index+1,nums);
            ans.remove(ans.size()-1);
        }
    }
}