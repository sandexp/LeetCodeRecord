// 排序双指针
class Solution {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int p1=0,p2=0;
        int min=Integer.MAX_VALUE;
        long tmp=0;
        while(p1<a.length && p2<b.length){
            if(a[p1]>b[p2]){
                tmp=(long)a[p1]-(long)b[p2];
                if(tmp<=Integer.MAX_VALUE)
                    min=Math.min(min,(int)tmp);
                p2++;
            }else if(a[p1]<b[p2]){
                tmp=(long)b[p2]-(long)a[p1];
                if(tmp<=Integer.MAX_VALUE)
                    min=Math.min(min,(int)tmp);
                p1++;
            }else
                return 0;
        }
        return min;
    }
}