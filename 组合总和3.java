class Solution {
    
    List<List<Integer>> ans=new ArrayList();
    List<Integer> template=new ArrayList();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k,n,1);
        return ans;
    }

    public void dfs(int k,int n,int index){
        if(n<0)
            return;
        if(index==10 && k>0)
            return;
        if(k==0){
            if(n==0)
                ans.add(new ArrayList(template));
            return;
        }
        template.add(index);
        dfs(k-1,n-index,index+1);
        template.remove(template.size()-1);
        dfs(k,n,index+1);
    }
}