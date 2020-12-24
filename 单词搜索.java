class Solution {

    boolean[][] status=new boolean[201][201];

    public boolean exist(char[][] board, String word) {
        if(board==null)
            return false;
        if(word.length()==0)
            return true;
        if(board.length==1 && board[0].length==1 && word.length()==1)
            return board[0][0]==word.charAt(0);
        boolean ans=false;
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                if(board[x][y]==word.charAt(0)){
                    ans=dfs(board,word,0,x,y);
                    if(ans)
                        return true;
                }
            }
        }
        return ans;
    }
    
    public boolean dfs(char[][] board,String word,int index,int x,int y){
        if(index==word.length())
            return true;
        if(x<0 || x>=board.length || y<0 || y>=board[0].length)
            return false;
        if(word.charAt(index)==board[x][y] && status[x][y]==false){
            status[x][y]=true;
            boolean a1=dfs(board,word,index+1,x-1,y);
            boolean a2=dfs(board,word,index+1,x,y-1);
            boolean a3=dfs(board,word,index+1,x+1,y);
            boolean a4=dfs(board,word,index+1,x,y+1);
            if((a1 || a2 || a3 || a4)==false)
                status[x][y]=false;
            else
                return true;
        }else{
            return false;
        }
        return false;
    }
}