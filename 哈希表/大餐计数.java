class Solution {

    /**
    做两个hash表
    一个用于放置2的幂次方数值
    另一个用于存放每种元素的数量
    直接两次遍历处理完毕
    
     */
    public int countPairs(int[] deliciousness) {
        if(deliciousness.length==0)
            return 0;
        final int MOD = 1000000007;
        Map<Integer,Integer> map=new HashMap();
        for(int c:deliciousness){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int[] t=new int[22];
        t[0]=1;
        for(int i=1;i<22;i++)
            t[i]=2*t[i-1];

        int ans=0;
        for(int i=0;i<deliciousness.length;i++){
            if(!map.containsKey(deliciousness[i]))
                continue;
            for(int j=0;j<22;j++){
                if(deliciousness[i]*2==t[j]){
                    // System.out.println("Ans= "+ans);
                    if(map.get(deliciousness[i])>=2){
                        int tmp=map.get(deliciousness[i]);
                        long val=(long)((long)tmp*(long)(tmp-1)/2);
                        ans+=val%MOD;
                        ans=ans%MOD;
                    }
                }else{
                    ans+=map.getOrDefault(deliciousness[i],0)*map.getOrDefault(t[j]-deliciousness[i],0);
                    ans=ans%MOD;
                }
            }
            map.remove(deliciousness[i]);
            
        }
        return ans%MOD;
    }
}