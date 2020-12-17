class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        boolean[][] status=new boolean[n][n];
        int num=1,x=0,y=0;
        int direct=1;
        while(num<=n*n){
            ans[x][y]=num;
            status[x][y]=true;
            num++;
            switch(direct){
                case 1:
                    if(y==n-1 || status[x][y+1]==true){
                        // System.out.println("Value");
                        direct++;
                        x++;
                    } else {
                        y++;
                    }
                break;
                case 2:
                    if(x==n-1 || status[x+1][y]==true){
                        direct++;
                        y--;
                    }else{
                        x++;
                    }
                break;
                case 3:
                    if(y==0 || status[x][y-1]==true){
                        direct++;
                        x--;
                    }else{
                        y--;
                    }
                break;
                case 4:
                    if(x==0 || status[x-1][y]==true){
                        direct=1;
                        y++;
                    }else{
                        x--;
                    }
                break;
            }
        }
        return ans;
    }
}