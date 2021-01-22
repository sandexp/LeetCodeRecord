class Solution {
    public int findNthDigit(int n) {
        if(n<10)
            return n;
        long base=9,radix=10,pow=1;
        while(n>base){
            pow++;
            base+=radix*9*pow;
            radix*=10;
        }
        long start=radix/10;
        base-=start*9*pow;
        long group=(n-base-1)/pow+start;
        long bit=(n-base)%pow==0?0:pow-(n-base)%pow;
        if(group<start)
            group=start;
        while(bit>0){
            group/=10;
            bit--;
        }
        return (int)(group%10);
    }
}