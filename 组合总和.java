class Solution {

    // 完全背包问题
    List<List<Integer>>  ans=new ArrayList();
    List<Integer> template=new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0);
        return ans;
    }

    public void dfs(int[] candidates,int target,int index){
        if(target==0){
            ans.add(new ArrayList(template));
            return;
        }
        if(target<0)
            return;
        if(index==candidates.length && target!=0)
            return;
        template.add(candidates[index]);
        dfs(candidates,target-candidates[index],index);
        template.remove(template.size()-1);
        dfs(candidates,target,index+1);
    }
}