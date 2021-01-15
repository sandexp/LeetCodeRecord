class Solution {
    /**
     * O(1)时间复杂度
     */
    public int addDigits(int num) {
        if(num<10)
            return num;
        int ans=0;
        while(num>0){
            ans+=num%10;
            num/=10;
        }
        int ret=ans/10+ans%10;
        if(ret>9)
            return ret/10+ret%10;
        else
            return ret;
    }
}