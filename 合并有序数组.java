/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
   说明：
   初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
   你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cnt=0,tmp=0;
        while(cnt<n){
            nums1[m]=nums2[cnt];
            for(int i=m;i>0;i--){
                if(nums1[i-1]>nums1[i]){
                    tmp=nums1[i-1];
                    nums1[i-1]=nums1[i];
                    nums1[i]=tmp;
                } else {
                    break;
                }
            }
            cnt++;
            m++;
        }
    }
}