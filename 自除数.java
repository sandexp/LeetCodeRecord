class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        if(left>right)
            return null;
        List<Integer> ans=new ArrayList();
        int x=left;
        while(x<=right){
            int divide=x;
            boolean flag=true;
            while(divide>0){    
                if(divide%10==0 || x%(divide%10)!=0){
                    flag=false;
                    break;
                }
                divide=divide/10;
            }
            if(flag)
                ans.add(x);
            x++;
        }
        return ans;
    }
}