class Solution {
    // 快速幂
    public int superPow(int a, int[] b) {
        if(a==1)
            return 1;
        int[] base=new int[b.length];
        base[base.length-1]=a%1337;
        int p=base.length-2;
        while(p>=0){
            int cnt=0,tmp=1;
            while(cnt<10){
                tmp=((base[p+1]%1337)*(tmp%1337))%1337;
                cnt++;
            }
            base[p]=tmp;
            p--;
        }
        p=0;
        while(p<b.length){
            if(b[p]==0){
                base[p]=1;
                p++;
                continue;
            }
            int cnt=0,tmp=1;
            while(cnt<b[p]){
                tmp=((base[p]%1337)*(tmp%1337))%1337;
                cnt++;
            }
            base[p]=tmp;
            p++;
        }
        int ans=1;
        p=0;
        while(p<b.length){
            ans=((ans%1337)*(base[p]%1337))%1337;
            p++;
        }
        return ans;
    }
}