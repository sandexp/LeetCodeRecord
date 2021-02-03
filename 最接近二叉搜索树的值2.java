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

    List<Integer> list=new ArrayList();

    public void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public double getMin(double a,double b){
        return b>a?b-a:a-b;
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        dfs(root);
        int index=list.size();
        List<Integer> ans=new ArrayList();
        for(int i=0;i<list.size();i++){
            if(list.get(i)>=target){
                if(list.get(i)==target)
                    index=i;
                else if(i==0)
                    index=i;
                else{
                    if(getMin(list.get(i-1),target)>getMin(list.get(i),target))
                        index=i;
                    else
                        index=i-1;
                }
                k--;
                ans.add(list.get(index));
                break;
            }
        }
        int left=index-1,right=index+1;
        while(k>0 && !(left<0 && right>=list.size())){
            if(left<0){
                ans.add(list.get(right));
                right++;
            }else if(right>=list.size()){
                ans.add(list.get(left));
                left--;
            }else{
                if(getMin(list.get(left),target)>getMin(list.get(right),target)){
                    ans.add(list.get(right));
                    right++;
                }else{
                    ans.add(list.get(left));
                    left--;
                }
            }
            k--;
        }
        return ans;
    }
}