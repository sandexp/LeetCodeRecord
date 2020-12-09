class Solution {

    /**
        路径方向
            右--> 下 --> 左 --> 上
            1     2      3      4
    */
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null)
            return null;
        int lines=matrix.length;
        int cols=matrix[0].length;
        if(lines==0 || cols==0)
            return null;
        boolean[][] status=new boolean[lines][cols];
        int x=0,y=0;
        int direct=1;
        List<Integer> ans=new ArrayList();
        while(true){
            if(x>=lines || y>=cols || x<0 || y<0)
                break;
            if(status[x][y]==true)
                break;
            ans.add(matrix[x][y]);
            status[x][y]=true;
            switch(direct){
                case 1:
                    if(y+1>=cols || status[x][y+1]==true){
                        direct++;
                        // 向下
                        x++;
                    }else{
                        y++;
                    }
                break;

                case 2:
                    if(x+1>=lines || status[x+1][y]==true){
                        direct++;
                        // 向左
                        y--;
                    }else{
                        x++;
                    }
                break;

                case 3:
                    if(y-1<0 || status[x][y-1]==true){
                        direct++;
                        // 向上
                        x--;
                    }else{
                        y--;
                    }
                break;

                case 4:
                    if(x-1<0 || status[x-1][y]==true){
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