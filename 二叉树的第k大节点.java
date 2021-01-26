/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    List<Integer> list=new ArrayList();
    
    public void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        if(k>list.size())
            return -1;
        return list.get(list.size()-k);
    }
}