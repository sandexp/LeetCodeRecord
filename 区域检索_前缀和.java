class NumMatrix {

    private int[][] matrix;

    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        if(matrix.length==0 || matrix[0].length==0)
            prefix=new int[0][0];
        else
            prefix=new int[matrix.length][matrix[0].length];
        for(int i=0;i<this.matrix.length;i++)
            prefix[i][0]=this.matrix[i][0];
        for(int i=0;i<this.matrix.length;i++){
            for(int j=1;j<this.matrix[0].length;j++)
                prefix[i][j]=prefix[i][j-1]+this.matrix[i][j];
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans=0;
        for(int i=row1;i<=row2;i++)
            ans+=prefix[i][col2]-prefix[i][col1]+this.matrix[i][col1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */