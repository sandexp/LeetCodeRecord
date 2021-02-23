class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap();
        Map<Integer,List<Integer>> query=new TreeMap(new Comparator<Integer>(){
            public int compare(Integer p1, Integer p2) {
                return p2-p1;
            }
        });
        for(int num:nums){
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }
        for(Integer val:map.values()){
            if(!query.containsKey(val))
                query.put(val,new ArrayList());
        }
        for(Integer key:map.keySet()){
            query.get(map.get(key)).add(key);
        }
        List<Integer> ans=new ArrayList();
        for(Integer key:query.keySet()){
            for(int i=0;i<query.get(key).size();i++){
                ans.add(query.get(key).get(i));
                k--;
            }
            if(k<=0)
                break;
        }
        int[] res=new int[ans.size()];
        for(int i=0;i<res.length;i++)
            res[i]=ans.get(i);
        return res;
    }
}