class Solution {
    public String addStrings(String num1, String num2) {
        int sign=0;
        char[] s1;
        char[] s2;
        if(num2.length()<num1.length()){
            s1=new StringBuffer(num1).reverse().toString().toString().toCharArray();
            s2=new StringBuffer(num2).reverse().toString().toString().toCharArray();
        }else{
            s1=new StringBuffer(num2).reverse().toString().toString().toCharArray();
            s2=new StringBuffer(num1).reverse().toString().toString().toCharArray();
        }
        int p=0;int tmp='0';
        while(p<s2.length){
            tmp=s1[p]-'0'+s2[p]-'0'+sign;
            s1[p]=(char)(tmp%10+'0');
            sign=tmp/10;
            p++;
        }
        while(p<s1.length){
            tmp=s1[p]-'0'+sign;
            s1[p]=(char)(tmp%10+'0');
            sign=tmp/10;
            p++;
        }
        StringBuffer sb=new StringBuffer();
        
        if(sign!=0)
            sb.append('1');
        p--;
        while(p>=0){
            sb.append(s1[p]);
            p--;
        }
        return sb.toString();
    }
}