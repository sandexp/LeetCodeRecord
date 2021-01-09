class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null)
            return new int[]{};
        if(nums1.length==0 || nums2.length==0)
            return new int[]{};
        Map<Integer,Integer>  map=new HashMap();
        for(int a: nums1){
            if(!map.containsKey(a))
                map.put(a,1);
        }
        int cnt=0;
        for(int a: nums2){
            if(map.containsKey(a) && map.get(a)==1){
                map.put(a,-1);
                cnt++;
            }
        }
        int[] ans=new int[cnt];
        int p=0;
        for(int key:map.keySet()){
            if(map.get(key)==-1){
                ans[p]=key;
                p++;
            }
        }
        return ans;
    }
}