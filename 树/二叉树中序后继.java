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

    List<TreeNode> list=new ArrayList();
    int index=-1;

    public void dfs(TreeNode root,TreeNode p){
        if(root==null)
            return;
        
        dfs(root.left,p);
        list.add(root);
        if(root.val==p.val){
            index=list.size();
        }
        dfs(root.right,p);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null)
            return null;
        dfs(root,p);
        if(index==-1 || index>=list.size()){
            return null;
        }else{
            return list.get(index);
        }
    }
}
