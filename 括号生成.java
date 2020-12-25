class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList();
        dfs(0,n,new StringBuffer(),0,0,ans);
        return ans;
    }

    public void dfs(int index,int n,StringBuffer template,int left,int right,List<String> ans){
        if(index==2*n){
            if(left==n && right==n)
                ans.add(template.toString());
            return;
        }

        if(left<=n){
            template.append('(');
            left++;
            dfs(index+1,n,template,left,right,ans);
            left--;
            template.deleteCharAt(template.length()-1);
        }
        if(left>right){
            template.append(')');
            right++;
            dfs(index+1,n,template,left,right,ans);
            right--;
            template.deleteCharAt(template.length()-1);
        }
    }
}