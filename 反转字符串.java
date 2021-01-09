class Solution {
    public String reverseStr(String s, int k) {
        StringBuffer ans=new StringBuffer();
        StringBuffer template=new StringBuffer();
        int p=0;
        while((p+2*k-1)<s.length()){
            template.append(s.substring(p,p+k));
            ans.append(template.reverse().toString());
            ans.append(s.substring(p+k,p+2*k));
            template.setLength(0);
            p+=2*k;
        }
        if(s.length()-p<k){
            template.append(s.substring(p,s.length()));
            ans.append(template.reverse().toString());
        }else{
            template.append(s.substring(p,p+k));
            ans.append(template.reverse().toString());
            ans.append(s.substring(p+k,s.length()));
        }
        
        return ans.toString();
    }
}