class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k)
            return "0";
        Stack<Integer> stack=new Stack();
        StringBuffer sb=new StringBuffer();
        int index=num.length(),maxn=num.length()-k;
        for(int i=0;i<num.length();i++){
            if(stack.empty()){
                stack.push(i);
            }else{
                while(num.charAt(stack.peek())>num.charAt(i) && k>0){
                    k--;
                    stack.pop();
                    if(stack.empty())
                        break;
                }
                if(!stack.empty() && num.charAt(stack.peek())==num.charAt(i))
                    stack.push(i);
                else if(stack.size()<maxn)
                    stack.push(i);
                if(k==0){
                    index=i;
                    break;
                }
            }
        }
        int cnt=0;
        while(!stack.empty() && cnt<maxn){
            cnt++;
            sb.append(num.charAt(stack.pop()));
        }
        sb.reverse();
        for(int i=index+1;i<num.length();i++)
            sb.append(num.charAt(i));
        String ans=sb.toString();
        for(int i=0;i<=ans.length();i++){
            if(i==ans.length())
                return "0";
            if(ans.charAt(i)!='0'){
                index=i;
                break;
            }
        }
        return ans.substring(index,ans.length());
    }
}