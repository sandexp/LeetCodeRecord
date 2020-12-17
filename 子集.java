/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
   说明：解集不能包含重复的子集。 
 */
class Solution {
    
    List<List<Integer>> ans=new ArrayList();
    List<Integer> template=new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums,nums.length);
        return ans;
    }

    public void dfs(int index,int[] nums,int size){
        if(index==size){
            ans.add(new ArrayList<>(template));
            return;
        }
        template.add(nums[index]);
        dfs(index+1,nums,size);
        template.remove(template.size()-1);
        dfs(index+1,nums,size);
    }
}