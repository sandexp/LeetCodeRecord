class Solution {

    public String decode(String s){
        StringBuffer sb=new StringBuffer();
        int p=0,repeat=0,st=0;
        Stack<Integer> stack=new Stack();
        while(p<s.length()){
            if(s.charAt(p)<='9' && s.charAt(p)>='0' && stack.isEmpty()){
                repeat*=10;
                repeat+=s.charAt(p)-'0';
            }
            if(s.charAt(p)=='['){
                stack.push(p);
            } else if(s.charAt(p)==']'){
                st=stack.pop();
                if(stack.isEmpty()){
                    String tmp=decode(s.substring(st+1,p));
                    for(int i=0;i<repeat;i++)
                        sb.append(tmp);
                    repeat=0;
                }
            }else if(stack.isEmpty() && !(s.charAt(p)<='9' && s.charAt(p)>='0'))
                sb.append(s.charAt(p));
            p++;
        }
        return sb.toString();
    }

    public String decodeString(String s) {
        return decode(s);
    }
}