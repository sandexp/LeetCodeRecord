class Solution {
    public String reverseWords(String s) {
        if(s.length()==0)
            return "";
        StringBuffer ans=new StringBuffer();
        StringBuffer template=new StringBuffer();
        int p1=0,p2=0;
        while(p2<=s.length()){
            if( p2==s.length()|| s.charAt(p2)==' '){
                template.append(s.substring(p1,p2));
                ans.append(template.reverse().toString());
                ans.append(' ');
                template.setLength(0);
                p2++;
                p1=p2;
            }else{
                p2++;
            }
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}