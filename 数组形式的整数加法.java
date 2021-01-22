class Solution {
    public List<Integer> addToArrayForm(int[] A, int k) {
        List<Integer> ans=new ArrayList();
        int p=A.length-1;
        int sign=0;
        while(p>=0 && k>0){
            int tmp=(sign+(k%10)+A[p])%10;
            ans.add(tmp);
            sign=(sign+(k%10)+A[p])/10;
            p--;
            k/=10;
        }
        while(p>=0){
            int tmp=(sign+A[p])%10;
            ans.add(tmp);
            sign=(sign+A[p])/10;
            p--;
        }
        while(k>0){
            int tmp=(sign+(k%10))%10;
            ans.add(tmp);
            sign=(sign+(k%10))/10;
            k/=10;
        }
        if(sign!=0)
            ans.add(sign);
        Collections.reverse(ans);
        return ans;
    }
}