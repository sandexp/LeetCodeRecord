class Solution {
    /**
        生命游戏 原地修改
        1 存活
        0 死亡
        -1 生存-> 死亡
        2   死亡-> 生存
    */
    public void gameOfLife(int[][] board) {
        if(board==null)
            return;
        int tmp=-2;
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                tmp=getSum(board,x,y);
                if(board[x][y]==0 && tmp==3){
                    board[x][y]=2;
                }else if(board[x][y]==1 && tmp<2){
                    board[x][y]=-1;
                }else if(board[x][y]==1 && tmp>3){
                    board[x][y]=-1;
                }
            }
        }

        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                if(board[x][y]==-1)
                    board[x][y]=0;
                if(board[x][y]==2)
                    board[x][y]=1;
            }
        }
    }

    public int getSum(int[][] board,int x,int y){
        int sum=0;
        sum+=getState(board,x-1,y+1);
        sum+=getState(board,x,y+1);
        sum+=getState(board,x+1,y+1);
        sum+=getState(board,x-1,y);
        sum+=getState(board,x+1,y);
        sum+=getState(board,x-1,y-1);
        sum+=getState(board,x,y-1);
        sum+=getState(board,x+1,y-1);
        return sum;
    }

    public int getState(int[][] board,int x,int y){
        if(x<0 || y<0 || x>=board.length || y>=board[0].length)
            return 0;
        int ans=-2;
        switch(board[x][y]){
            case 0:
                ans=0;
            break;
            case -1:
                ans=1;
            break;
            case 2:
                ans=0;
            break;
            case 1:
                ans=1;
            break;
        }
        return ans;
    }
}