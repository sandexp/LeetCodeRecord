class Solution {
    public boolean isMonotonic(int[] A) {
        if(A.length<=2)
            return true;
        int p=0,delta=0;
        for(int i=0;i<A.length;i++){
            if(A[i]!=A[0]){
                p=i;
                break;
            }
        }
        delta=A[p]-A[0];
        while(p<A.length-1){
            if((A[p+1]-A[p])*delta<0)
                return false;
            p++;
        }
        return true;
    }
}