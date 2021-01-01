class Solution {

    boolean[][] status=new boolean[50][50];
    
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        int tmp=-2;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0 || (grid[i][j]==1 && status[i][j]==true))
                    continue;
                tmp=search(grid,i,j);
                if(tmp>ans)
                    ans=tmp;
            }
        }
        return ans;
    }

    public int search(int[][] grid,int x,int y){
        int ans=1;
        status[x][y]=true;
        if(x>0 && (status[x-1][y]==false && grid[x-1][y]==1))
            ans+=search(grid,x-1,y);
        if(x<grid.length-1 && (status[x+1][y]==false && grid[x+1][y]==1))
            ans+=search(grid,x+1,y);
        if(y>0 && (status[x][y-1]==false && grid[x][y-1]==1))
            ans+=search(grid,x,y-1);
        if(y<grid[0].length-1 && (status[x][y+1]==false && grid[x][y+1]==1))
            ans+=search(grid,x,y+1);
        return ans;
    }
}