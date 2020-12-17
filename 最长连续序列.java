/**
 * 给定一个未排序的整数数组 nums ，
 * 找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * 使用并查集+压缩的方法
 * 时间复杂度在O(n)级别:
 * 遍历一次执行n次,执行m次压缩,共计执行2n次压缩编码操作
 * 共计3n次执行
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int tmp,maxm,ans=-1;
        Map<Integer,Integer> map=new HashMap();
        for(int num:nums)
            map.put(num,1);
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=1)
                continue;
            tmp=nums[i];
            while(map.containsKey(tmp+1)){
                tmp++;
            }
            maxm=tmp;
            while(map.containsKey(tmp)){
                map.put(tmp,maxm-tmp+1);
                tmp--;
            }
        }
        for(Integer number:map.keySet()){
            if(map.get(number)>ans){
                ans=map.get(number);
            }
        }
        return ans;
    }
}