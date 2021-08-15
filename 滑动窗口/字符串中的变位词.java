class Solution {

    // 4895 1249
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

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }    

        int size= s1.length();

        Map<Character,Integer> map1=new HashMap();
        Map<Character,Integer> map2=new HashMap();


        for(int i=0;i<size;i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }
        if(isEqual(map1,map2)){
            return true;
        }
        for(int i=size;i< s2.length();i++){
            char c1=s2.charAt(i);
            char c2=s2.charAt(i-size);
            // System.out.println("C1= "+c1+"\tC2= "+c2);
            map2.put(c1,map2.getOrDefault(c1,0)+1);
            map2.put(c2,map2.getOrDefault(c2,0)-1);

            if(map2.get(c2) ==0 ){
                map2.remove(c2);
            }

            if(isEqual(map1,map2)){
                return true;
            }
        }

        return false;

    }
}