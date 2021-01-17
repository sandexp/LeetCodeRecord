class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<3)
            return true;
        int dy=coordinates[1][1]-coordinates[0][1],dx=coordinates[1][0]-coordinates[0][0];
        int y=0,x=0;
        for(int i=2;i<coordinates.length;i++){
            y=coordinates[i][1]-coordinates[i-1][1];
            x=coordinates[i][0]-coordinates[i-1][0];
            if(x*dy!=y*dx)
                return false;
        }
        return true;
    }
}