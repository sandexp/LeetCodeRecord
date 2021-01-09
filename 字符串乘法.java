class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        if(num1.length()<num2.length()){
            String s=num1;
            num1=num2;
            num2=s;
        }
        String ans="0";
        String tmp="";
        String suffix="";
        for(int i=num2.length()-1;i>=0;i--){
            tmp=mul(num1,num2.charAt(i));
            tmp=tmp+suffix;
            ans=add(ans,tmp);
            suffix=suffix+"0";
        }
        return ans;
    }

    public String mul(String s1, char c){
        int sign=0;
        int p=1;
        int tmp=0;
        StringBuffer sb=new StringBuffer();
        while(s1.length()-p>=0){
            tmp=((s1.charAt(s1.length()-p)-'0')*(c-'0')+sign)%10;
            sign=((s1.charAt(s1.length()-p)-'0')*(c-'0')+sign)/10;
            sb.append(tmp);
            p++;
        }
        if(sign!=0)
            sb.append(sign);
        return sb.reverse().toString();
    }

    public String add(String s1,String s2){
        int p=1;
        int tmp=0,sign=0;
        StringBuffer sb=new StringBuffer();
        while(s1.length()-p>=0 && s2.length()-p>=0){
            tmp=((s1.charAt(s1.length()-p)-'0')+(s2.charAt(s2.length()-p)-'0')+sign)%10;
            sign=((s1.charAt(s1.length()-p)-'0')+(s2.charAt(s2.length()-p)-'0')+sign)/10;
            sb.append(tmp);
            p++;
        }
        while(s1.length()-p>=0){
            tmp=(s1.charAt(s1.length()-p)-'0'+sign)%10;
            sign=(s1.charAt(s1.length()-p)-'0'+sign)/10;
            sb.append(tmp);
            p++;
        }
        while(s2.length()-p>=0){
            tmp=(s2.charAt(s2.length()-p)-'0'+sign)%10;
            sign=(s2.charAt(s2.length()-p)-'0'+sign)/10;
            sb.append(tmp);
            p++;
        }
        if(sign!=0)
            sb.append(sign);
        return sb.reverse().toString();
    }
}