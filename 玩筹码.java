class Solution {
    public int minCostToMoveChips(int[] position) {
        if(position==null)
            return 0;
        int odd=0,even=0;
        for(int p:position){
            if(p % 2==0)
                even++;
            else
                odd++;
        }
        return Math.min(even,odd);
    }
}