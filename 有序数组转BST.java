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
    
    public TreeNode insertNode(int[] nums,int start,int end){
        if(start<0 || end>nums.length-1)
            return null;
        if(start>end)
            return null;
        if(start==end)
            return new TreeNode(nums[start],null,null);
        TreeNode ret=new TreeNode(nums[(start+end)/2]);
        ret.left=insertNode(nums,start,(start+end)/2-1);
        ret.right=insertNode(nums,(start+end)/2+1,end);
        return ret;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null)
            return null;
        TreeNode root=insertNode(nums,0,nums.length-1);
        return root;
    }
}