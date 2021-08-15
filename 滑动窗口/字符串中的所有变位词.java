class Solution {

    boolean isEqual(Map<Character,Integer> map1, Map<Character,Integer> map2){
        if(map1.size()!=map2.size()){
            return false;
        }

        for(Character c: map1.keySet()){
            if(!map2.containsKey(c)){
                return false;
            }
            if(!map2.get(c).equals(map1.get(c))){
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList();
        if(p.length()>s.length()){
            return ans;
        }    

        int size= p.length();

        Map<Character,Integer> map1=new HashMap();
        Map<Character,Integer> map2=new HashMap();


        for(int i=0;i<size;i++){
            map1.put(p.charAt(i),map1.getOrDefault(p.charAt(i),0)+1);
            map2.put(s.charAt(i),map2.getOrDefault(s.charAt(i),0)+1);
        }
        if(isEqual(map1,map2)){
            ans.add(0);
        }
        for(int i=size;i< s.length();i++){
            char c1=s.charAt(i);
            char c2=s.charAt(i-size);
            map2.put(c1,map2.getOrDefault(c1,0)+1);
            map2.put(c2,map2.getOrDefault(c2,0)-1);

            if(map2.get(c2) ==0 ){
                map2.remove(c2);
            }

            if(isEqual(map1,map2)){
                ans.add(i-size+1);
            }
        }

        return ans;
    }
}