/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int ans=0;

    public void dfs(TreeNode root,StringBuffer sb){
        if(root==null)
            return;
        sb.append(root.val);
        if(root.left==null && root.right==null){
            ans+=Integer.parseInt(sb.toString());
            return;
        }
        dfs(root.left,new StringBuffer(sb.toString()));
        dfs(root.right,new StringBuffer(sb.toString()));
    }

    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,new StringBuffer());
        return ans;
    }
}