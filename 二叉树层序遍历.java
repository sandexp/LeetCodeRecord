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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList();
        if(root==null)
            return ans;

        Queue<TreeNode> queue=new LinkedList();
        List<TreeNode> list=new ArrayList();
        Map<TreeNode,Integer> map=new HashMap();

        map.put(root,0);
        queue.offer(root);
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
        int maxn=map.get(list.get(list.size()-1));
        for(int i=0;i<=maxn;i++)
            ans.add(new ArrayList());
        
        for(int i=0;i<list.size();i++){
            ans.get(maxn-map.get(list.get(i))).add(list.get(i).val);
        }
        return ans;
    }
}