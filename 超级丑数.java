class Solution {
	// 超时
    public int nthSuperUglyNumber(int n, int[] primes) {
        Queue<Integer> queue=new PriorityQueue();
        Set<Integer> set=new HashSet();
        queue.add(1);
        int cnt=1;
        while(cnt<n+1){
            cnt++;
            int tmp=queue.poll();
            if(cnt==n+1)
                return tmp;
            for(int x:primes){
                if(!set.contains(x*tmp)){
                    set.add(x*tmp);
                    queue.add(x*tmp);
                }
            }
        }
        return  0;
    }
}