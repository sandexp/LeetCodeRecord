class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode left=root.left;
        TreeNode right=root.right;
        // 调整下一层
        root.left=mirrorTree(right);
        root.right=mirrorTree(left);
        return root;
    }
}