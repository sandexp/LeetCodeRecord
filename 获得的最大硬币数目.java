class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int p1=0,p2=piles.length-1;
        boolean flag=false;
        List<Integer> list=new ArrayList();
        while(p1<p2){
            if(!flag){
                list.add(piles[p2]);
                p2--;
                list.add(piles[p2]);
                p2--;
                flag=true;
            }else{
                list.add(piles[p1]);
                flag=false;
                p1++;
            }
        }
        int ans=0;
        for(int i=1;i<list.size();i+=3)
            ans+=list.get(i);
        return ans;

    }
}