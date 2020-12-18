class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr==null || arr.length<3)
            return false;
        int p1=0,top=0;
        if(arr[p1+1]<=arr[p1])
            return false;
        while(p1<arr.length-1){
            if(arr[p1+1]==arr[p1])
                return false;
            if(arr[p1+1]<arr[p1]){
                top=p1;
                break;
            }
            p1++;
        }
        p1=top;
        while(p1<arr.length-1){
            if(arr[p1+1]>=arr[p1])
                return false;
            p1++;
        }
        return true;

    }
}