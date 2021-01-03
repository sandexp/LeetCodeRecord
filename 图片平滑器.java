class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] ans=new int[M.length][M[0].length];
        int tmp=0,cnt=0;
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                tmp=M[i][j];
                cnt=1;
                if(i-1>=0 && j-1>=0){
                    tmp+=M[i-1][j-1];
                    cnt++;
                }
                if(i-1>=0 && j>=0){
                    tmp+=M[i-1][j];
                    cnt++;
                }
                if(i-1>=0 && j+1<M[0].length){
                    tmp+=M[i-1][j+1];
                    cnt++;
                }
                if(i+1<M.length && j-1>=0){
                    tmp+=M[i+1][j-1];
                    cnt++;
                }
                if(i+1<M.length && j>=0){
                    tmp+=M[i+1][j];
                    cnt++;
                }
                if(i+1<M.length && j+1<M[0].length){
                    tmp+=M[i+1][j+1];
                    cnt++;
                }
                if(i>=0 && j-1>=0){
                    tmp+=M[i][j-1];
                    cnt++;
                }
                if(i>=0 && j+1<M[0].length){
                    tmp+=M[i][j+1];
                    cnt++;
                }
                ans[i][j]=tmp/cnt;
            }
        }
        return ans;
    }
}