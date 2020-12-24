class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList();
        if(rowIndex==0){
            ans.add(1);
            return ans;
        }
        long[] arr=new long[rowIndex+1];
        arr[0]=1;
        for(int i=1;i<=arr.length/2;i++)
            arr[i]=arr[i-1]*(rowIndex-i+1)/i;
        for(int i=rowIndex;i>=arr.length/2;i--)
            arr[i]=arr[rowIndex-i];
        for(long num:arr)
            ans.add((int)num);
        return ans;
    }
}