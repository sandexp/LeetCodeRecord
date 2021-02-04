class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] sl=s.toCharArray();
        char[] tl=t.toCharArray();
        Arrays.sort(sl);
        Arrays.sort(tl);
        int p=0;
        while(p<s.length()){
            if(sl[p]!=tl[p])
                return false;
            p++;
        }
        return true;
    }
}