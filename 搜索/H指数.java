class Solution {
    public int hIndex(int[] citations) {
        if(citations[0]>=citations.length)
            return citations.length;
        int ans=0;
        int left=0,right=citations.length-1;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            int h=citations.length-mid;// 论文数量
            if(citations[mid]>=h){
                // 看一看有没有更大的h值 right=mid
                right=mid-1;
            }else{
                // 不在区间内部 查看另外一个部分
                left=mid+1;
            }
            
        }
        return citations.length-left;
    }
}