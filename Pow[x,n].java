class Solution {
    /**
     * 快速幂+递归
     * @param  x 底数
     * @param  n 指数
     * @return   pow值
     */
    public double myPow(double x, int n) {
        if(n==0)
            return 1.0;
        boolean minus=n<0;
        long input=0;
        if(minus)
            input=(-1L)*(long)n;
        else
            input=n;
        double current=x;
        long delta=1;
        while(delta*2<input){
            current*=current;
            delta*=2;
        }
        if((delta*2-input)<(input-delta)){
            current*=current;
            for(long i=delta*2;i>input;i--)
                current/=x;
        }else{
            for(long i=delta;i<input;i++)
                current*=x;
        }
        return minus?1.0/current:current;
    }
}