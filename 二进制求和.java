class Solution {
    public String addBinary(String a, String b) {
        int sign=0,p=1;
        StringBuffer sb=new StringBuffer();
        char tmp='0';
        int m=0;
        int maxSize=Math.max(a.length(),b.length());
        while(a.length()-p>=0 && b.length()-p>=0){
            m=sign+(int)(a.charAt(a.length()-p)-'0')+(int)(b.charAt(b.length()-p)-'0');
            if(m>=2){
                sb.append(m-2);
                sign=1;
            }else{
                sb.append(m);
                sign=0;
            }
            p++;
        }
        while(a.length()-p>=0){
            m=sign+(a.charAt(a.length()-p)-'0');
            if(m>=2){
                sb.append(m-2);
                sign=1;
            }else{
                sb.append(m);
                sign=0;
            }
            p++;
        }
        while(b.length()-p>=0){
            m=sign+(b.charAt(b.length()-p)-'0');
            if(m>=2){
                sb.append(m-2);
                sign=1;
            }else{
                sb.append(m);
                sign=0;
            }
            p++;
        }
        if(sign==1)
            sb.append(1);
        sb.reverse();
        return sb.toString();
    }
}