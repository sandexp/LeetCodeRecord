public class Solution {

    // n& (n-1) 会把n最后一位置零,所以利用这个来测试0的数量, 当为0时直接结束, 可以加快迭代速度
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans=0;
        while(n!=0){
            n=n&(n-1);
            ans++;
        }
        return ans;
    }
}