class Solution {

    public int getType(char c){
        if(c<='9' && c>='0')
            return 0;
        if(c=='(')
            return 1;
        if(c==')')
            return 2;
        if(c==' ')
            return 3;
        if(c=='+')
            return 4;
        if(c=='-')
            return 5;
        return 6;
    }

    public int dfs(String s){
        Stack<Integer> stack=new Stack();
        Stack<Integer> s2=new Stack();
        char ops='+';
        for(int i=0;i<s.length();i++){
            switch(getType(s.charAt(i))){
                case 0:
                {
                    if(!s2.empty())
                        continue;
                    int p=i;
                    while(p<s.length()){
                        if(getType(s.charAt(p))!=0)
                            break;
                        p++;
                    }
                    int tmp=Integer.parseInt(s.substring(i,p));
                    if(ops=='-')
                        tmp=(-1)*tmp;
                    if(stack.empty())
                        stack.push(tmp);
                    else
                        stack.push(stack.pop()+tmp);
                    i=p-1;
                }
                break;
                case 1:
                    s2.push(i);
                break;
                case 2:
                {
                    int start=s2.pop();
                    if(s2.empty()){
                        int sub=dfs(s.substring(start+1,i));
                        if(ops=='-')
                            sub=(-1)*sub;
                        if(stack.empty())
                            stack.push(sub);
                        else
                            stack.push(stack.pop()+sub);
                    }
                }
                break;
                
                case 3:
                break;
                
                case 4:
                {
                    if(s2.empty())
                        ops='+';
                }
                break;
                
                case 5:
                {
                    if(s2.empty())
                        ops='-';
                }
                break;
            }
        }
        return stack.pop();
    }


    public int calculate(String s) {
        return dfs(s);
    }
}