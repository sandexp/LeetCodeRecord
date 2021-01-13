class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        if(arr==null || arr.length<3)
            return false;
        int sum=0;
        for(int i=0;i<arr.length;i++)
            sum+=arr[i];
        int p1=0,p2=0;
        int tmp=0;
        while(p1<arr.length){
            tmp+=arr[p1];
            if(tmp==sum/3)
                break;
            p1++;
        }
        p2=p1+1;
        tmp=0;
        while(p2<arr.length){
            tmp+=arr[p2];
            if(tmp==sum/3)
                break;
            p2++;
        }
        if(p1<arr.length-2 && p2<arr.length-1)
            return true;
        return false;
    }
}