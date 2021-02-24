class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int cols=A[0].length;
        int tmp=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<cols;j++){
                if(j<cols/2){
                    tmp=A[i][j];
                    A[i][j]=A[i][cols-j-1];
                    A[i][cols-j-1]=tmp;
                }
                A[i][j]=A[i][j]==0?1:0;
            }
        }
        return A;
    }
}