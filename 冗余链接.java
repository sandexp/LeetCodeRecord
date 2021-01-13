class Solution {

    int[] father=new int[1010];

    public int[] findRedundantConnection(int[][] edges) {
        for(int i=1;i<father.length;i++)
            father[i]=i;
        int a=-1,b=-2;
        for(int[] tmp:edges){
            a=getRoot(tmp[0]);
            b=getRoot(tmp[1]);
            if(a==b)
                return tmp;
            union(Math.min(a,b),Math.max(a,b));
        }
        return new int[0];
    }

    public int getRoot(int num){
        if(father[num]==num)
            return num;
        return getRoot(father[num]);
    }

    public void union(int a,int b){
        father[b]=a;
    }
}