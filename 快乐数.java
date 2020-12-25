class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet();
        int start=n;
        if(start==1)
            return true;
        while(!set.contains(start)){
            set.add(start);
            int sqrt=0;
            while(start>0){
                sqrt+=(start%10)*(start%10);
                start=start/10;
            }
            start=sqrt;
            if(start==1)
                return true;
        }
        return false;
    }
}