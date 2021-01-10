class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A.length==0 || A.length==1)
            return A;
        List<Integer> a=new ArrayList();
        List<Integer> b=new ArrayList();
        for(int x:A){
            if(x%2==0)
                a.add(x);
            else
                b.add(x);
        }
        int[] ans=new int[A.length];
        int p=0;
        for(Integer x:a){
            ans[p]=x;
            p++;
        }
        for(Integer x:b){
            ans[p]=x;
            p++;
        }
        return ans;
    }
}