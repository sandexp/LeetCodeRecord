class Solution {
    public String[] findWords(String[] words) {
        if(words==null || words.length==0)
            return new String[0];
        Map<Character,Integer> map=new HashMap();
        String[] tab=new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
        for(int i=0;i<3;i++){
            for(int j=0;j<tab[i].length();j++){
                map.put(tab[i].charAt(j),i);
                char c=(char)(tab[i].charAt(j)-32);
                map.put(c,i);
            }
        }
        List<String> ans=new ArrayList();
        for(String word:words){
            int line=map.get(word.charAt(0));
            boolean flag=true;
            for(int j=0;j<word.length();j++){
                if(map.get(word.charAt(j))!=line){
                    System.out.println(word.charAt(j));
                    flag=false;
                    break;
                }
            }
            if(flag)
                ans.add(word);
        }
        return ans.toArray(new String[ans.size()]);
    }
}