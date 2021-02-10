class Solution {

    // 排列相等则要求元素的数目和种类相同
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] t1=new int[26];
        int[] t2=new int[26];
        for(int i=0;i<s1.length();i++)
            t1[s1.charAt(i)-'a']++;
        for(int i=0;i<s1.length();i++)
            t2[s2.charAt(i)-'a']++;
        if(isEquals(t1,t2))
            return true;
        int left=1,right=s1.length();
        while(right<s2.length()){
            t2[s2.charAt(right)-'a']++;
            t2[s2.charAt(left-1)-'a']--;
            if(isEquals(t1,t2))
                return true;
            right++;
            left++;
        }
        
        return false;
    }

    public boolean isEquals(int[] t1,int[] t2){
        for(int i=0;i<26;i++){
            if(t1[i]!=t2[i])
                return false;
        }
        return true;
    }
}