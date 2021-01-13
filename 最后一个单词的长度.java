class Solution {
    public int lengthOfLastWord(String s) {
        int p=s.length()-1;
        int end=p;
        while(p>=0 && s.charAt(p)==' '){
            p--;
        }
        end=p;
        while(p>=0 && s.charAt(p)!=' '){
            p--;
        }
        int start=p;
        return end-start;
    }
}