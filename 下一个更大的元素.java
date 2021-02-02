class Solution {
	// 单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap();
        Stack<Integer> stack=new Stack();
        stack.push(nums2[0]);
        for(int i=1;i<nums2.length;i++){
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
        while(!stack.empty())
            map.put(stack.pop(),-1);
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}