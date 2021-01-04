class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null)
            return ;
        int MARKER=-99999999;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    for(int x=0;x<matrix.length;x++){
                        if(matrix[x][j]!=0)
                            matrix[x][j]=MARKER;
                    }
                    for(int x=0;x<matrix[0].length;x++){
                        if(matrix[i][x]!=0)
                            matrix[i][x]=MARKER;
                    }
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==MARKER)
                    matrix[i][j]=0;
            }
        }
    }
}