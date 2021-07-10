class TimeMap {


    private Map<String,TreeMap<Integer,String>> map=new HashMap();

    /** Initialize your data structure here. */
    public TimeMap() {

    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap(new Comparator<Integer>(){
                public int compare(Integer a,Integer b){
                    return b-a;			
                }
            }));
        }
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        String ans="";
        TreeMap<Integer,String> tmp=map.get(key);
        if(tmp==null)
            return ans;
        for(Integer time:tmp.keySet()){
            if(time<=timestamp){
                ans=tmp.get(time);
                break;
            }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */