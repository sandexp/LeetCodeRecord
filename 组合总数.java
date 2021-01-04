class Solution {
    
    List<List<Integer>> ans=new ArrayList();
    List<Integer> template=new ArrayList();
    Set<String> set=new HashSet();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return ans;
    }

    public void dfs(int[] candidates,int target,int index){
        if(target==0){
            StringBuffer sb=new StringBuffer();
            for(Integer i:template){
                sb.append(String.valueOf(i));
            }
            if(!set.contains(sb.toString())){
                set.add(sb.toString());
                ans.add(new ArrayList(template));
            }
            return;
        }
        if(index==candidates.length || target<0){
            return;
        }
        template.add(candidates[index]);
        dfs(candidates,target-candidates[index],index+1);
        template.remove(template.size()-1);
        dfs(candidates,target,index+1);
    }
}