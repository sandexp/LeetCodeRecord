
/**
 * LeetCode 4
 * 寻找两个正序数组的中位数
 */
public class MiddleOfOrderedArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int alen=nums1.length;
        int blen=nums2.length;
        double res=0;
        int cnt=(alen+blen)/2;
        int apoint=0,bpoint=0;
        boolean flag=(alen+blen)%2==0;
        while(apoint<alen && bpoint<blen){
            cnt--;
            if(nums1[apoint]<nums2[bpoint]){
                res=nums1[apoint];
                apoint++;
            } else{
                res=nums2[bpoint];
                bpoint++;
            }

            if(cnt==0){
                if(flag)
                    res=(res+nums1[apoint]>nums2[bpoint]?nums2[bpoint]:nums1[apoint])/2;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1=new int{1,2};
        int[] nums2=new int{3,4};
        double res= findMedianSortedArrays(nums1,nums2);
        System.out.println(res);
    }
}