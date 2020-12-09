// 自定义排序问题
class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null)
            return null;
        // 自定义字典序排序
        int tmp=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(compare(nums[i],nums[j])<0){
                    tmp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=tmp;
                }
            }
        }
        if(nums[0]==0)
            return "0";
        StringBuffer sb=new StringBuffer();
        for(int num:nums){
            sb.append(String.valueOf(num));
        }
        return sb.toString();
    }

    public int compare(int x,int y){
        if(x==y)
            return 0;
        String comp1=String.valueOf(x);
        String comp2=String.valueOf(y);
        int len1=comp1.length();
        int len2=comp2.length();
        int pt=0;
        while(pt<len1 && pt<len2){
            if(comp2.charAt(pt)==comp1.charAt(pt)){
                pt++;
                continue;
            }
            if(comp2.charAt(pt)>comp1.charAt(pt))
                return -1;
            else
                return 1;
        }
        // 处理前缀相等问题
        String comb1=comp1+comp2;
        String comb2=comp2+comp1;
        if(comb1.compareTo(comb2)>0)
            return 1;
        else
            return -1;
    }
}