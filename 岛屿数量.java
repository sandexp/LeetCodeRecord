class Solution {

    boolean[][] status=new boolean[301][301];

    public int numIslands(char[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !status[i][j]){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid,int x,int y){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length)
            return;
        if(grid[x][y]=='0' || status[x][y])
            return;
        status[x][y]=true;
        if(x<=grid.length-1)
            dfs(grid,x+1,y);
        if(y<=grid[0].length-1)
            dfs(grid,x,y+1);
        if(x>=0)
            dfs(grid,x-1,y);
        if(y>=0)
            dfs(grid,x,y-1);
    }
}