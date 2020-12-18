class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits==null)
            return false;
        if(bits.length==1)
            return bits[0]==0;
        int p=0;
        while(p<bits.length){
            if(p==bits.length-1 && bits[p]==0)
                return true;
            if(bits[p]==1)
                p+=2;
            else
                p++;
        }
        return false;
    }
}