class Solution {
    // 不使用存储版本
    public boolean isUnique(String astr) {
        if(astr.length()==0)
            return true;
        char[] c=astr.toCharArray();
        Arrays.sort(c);
        int p=0;
        while(p<c.length-1){
            if(c[p]==c[p+1])
                return false;
            p++;
        }
        return true;
    }
}