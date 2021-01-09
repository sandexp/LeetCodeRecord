class Solution {
    public int strStr(String haystack, String needle) {
        if(needle==null)
            return 0;
        if(haystack.equals(needle))
            return 0;
        if(needle=="")
            return 0;
        if(needle.length()>haystack.length())
            return -1;
        int p=0;
        while(p<haystack.length() && p+needle.length()-1<haystack.length()){
            if(haystack.substring(p,p+needle.length()).equals(needle))
                return p;
            else
                p++;
        }
        return -1;
    }
}