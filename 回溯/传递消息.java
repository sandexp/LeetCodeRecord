class Solution {

    int nums=0;

    public void dfs(int[][] relation,int k,int cnt,int val,int target){
        if(cnt==k){
            if(val==target){
                nums++;
            }
            return;
        }

        for(int i=0;i<relation.length;i++){
            if(relation[i][0]==val){
                dfs(relation,k,cnt+1,relation[i][1],target);
            }
        }

    }

    public int numWays(int n, int[][] relation, int k) {
        if(relation==null || relation.length==0)
            return 0;
        dfs(relation,k,0,0,n-1);
        return nums;
    }
}