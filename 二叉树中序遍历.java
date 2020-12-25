class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList();
        if(root==null)
            return ans;
        dfs(root,ans);
        return ans;
    }

    public void dfs(TreeNode root,List<Integer> ans){
        if(root==null)
            return;
        dfs(root.left,ans);
        ans.add(root.val);
        dfs(root.right,ans);
    }
}