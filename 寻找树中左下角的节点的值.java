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
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> list=new ArrayList();
        Queue<TreeNode> queue=new LinkedList();
        Map<TreeNode,Integer> map=new HashMap();
        queue.offer(root);
        map.put(root,0);
        while(!queue.isEmpty()){
            TreeNode tmp=queue.poll();
            list.add(tmp);
            if(tmp.left!=null){
                queue.offer(tmp.left);
                map.put(tmp.left,map.get(tmp)+1);
            }
            if(tmp.right!=null){
                queue.offer(tmp.right);
                map.put(tmp.right,map.get(tmp)+1);
            }
        }
        int maxlay=map.get(list.get(list.size()-1));
        for(int i=0;i<list.size();i++){
            if(map.get(list.get(i))==maxlay)
                return list.get(i).val;
        }
        return 0;
    }
}