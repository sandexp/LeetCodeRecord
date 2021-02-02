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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList();
        if(root==null)
            return ans;
        List<TreeNode> list=new ArrayList();
        Queue<TreeNode> queue=new LinkedList();
        Map<TreeNode,Integer> layers=new HashMap();
        queue.offer(root);
        layers.put(root,0);
        int maxlay=0;
        while(!queue.isEmpty()){
            TreeNode tmp=queue.poll();
            list.add(tmp);
            if(tmp.left!=null){
                queue.offer(tmp.left);
                layers.put(tmp.left,layers.get(tmp)+1);
                maxlay=layers.get(tmp)+1>maxlay?layers.get(tmp)+1:maxlay;
            }
            if(tmp.right!=null){
                queue.offer(tmp.right);
                layers.put(tmp.right,layers.get(tmp)+1);
                maxlay=layers.get(tmp)+1>maxlay?layers.get(tmp)+1:maxlay;
            }
        }

        for(int i=0;i<=maxlay;i++)
            ans.add(new ArrayList<Integer>());
        for(int i=0;i<list.size();i++)
            ans.get(layers.get(list.get(i))).add(list.get(i).val);
        for(int i=1;i<ans.size();i+=2)
            Collections.reverse(ans.get(i));
        return ans;
    }
}