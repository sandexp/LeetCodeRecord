class Solution {
    // 当 cnt=0 时 不能插入 ) 当cnt=n 时不能插入(
    /**
        插入( cnt++
        插入) cnt--

        (
        ()
        
     */

    List<String> ans=new ArrayList();


    public void dfs(StringBuffer sb,int n, int left, int right,int val){
        
        if(left==n && right==n){
            ans.add(sb.toString());
            return;
        }

        if(left>n)
            return;

        if(right>n)
            return;
        
        if(val==0){
            if(left==n){
                return;
            }
            sb.append('(');
            dfs(new StringBuffer(sb.toString()),n,left+1,right,val+1);
        }else if(val==n){
            sb.append(')');
            dfs(new StringBuffer(sb.toString()),n,left,right+1,val-1);
        }else{
            sb.append('(');
            dfs(new StringBuffer(sb.toString()),n,left+1,right,val+1);
            sb.deleteCharAt(sb.length()-1);
            sb.append(')');
            dfs(new StringBuffer(sb.toString()),n,left,right+1,val-1);
        }

    }

    public List<String> generateParenthesis(int n) {
        dfs(new StringBuffer(),n,0,0,0);
        return ans;
    }
}