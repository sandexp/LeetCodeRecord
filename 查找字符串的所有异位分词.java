class Solution {

    public boolean isEqual(Map<Character,Integer> base,Map<Character,Integer> map){
        if(base.size()!=map.size())
            return false;
        for(Character key:base.keySet()){
            int val=base.get(key);
            if(!map.containsKey(key) || map.get(key)!=val)
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int size=p.length();
        List<Integer> ans=new ArrayList();
        if(s.length()<size)
            return ans;

        Map<Character,Integer> base=new HashMap();
        Map<Character,Integer> map=new HashMap();

        for(int i=0;i<size;i++){
            if(!base.containsKey(p.charAt(i)))
                base.put(p.charAt(i),1);
            else
                base.put(p.charAt(i),base.get(p.charAt(i))+1);
        
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1);
            else
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }  

        int start=0;
        while(start+size<s.length()+1){
            if(isEqual(base,map))
                ans.add(start);

            if(map.get(s.charAt(start))<=1)
                map.remove(s.charAt(start));
            else
                map.put(s.charAt(start),map.get(s.charAt(start))-1);

            
            if(start+size>=s.length())
                break;
            
            if(!map.containsKey(s.charAt(start+size)))
                map.put(s.charAt(start+size),1);
            else
                map.put(s.charAt(start+size),map.get(s.charAt(start+size))+1);

            start++;
        }
        return ans;
    }
}