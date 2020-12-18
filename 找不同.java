class Solution {
    public char findTheDifference(String s, String t) {

        char[] sa=s.toCharArray();
        char[] ta=t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        int p=0;
        while(p<sa.length){
            if(sa[p]!=ta[p])
                return ta[p];
            p++;
        }
        return ta[p];
        
    }
}