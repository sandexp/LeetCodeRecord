class Solution {

    public String dfs(String expression){
        if(expression.length()==1)
            return expression;
        String ans="";
        Stack<Integer> stack=new Stack();
        boolean status=false;
        for(int i=0;i<expression.length();i++){
            if(stack.empty()){
                switch(expression.charAt(i)){
                    case '?':
                        stack.push(i);
                    break;
                    case 'F':
                        status=false;
                    break;
                    case 'T':
                        status=true;
                    break;
                }
            }else{
                if(expression.charAt(i)=='?')
                    stack.push(i);
                else if(expression.charAt(i)==':'){
                    int start=stack.pop();
                    if(stack.empty()){
                        if(status)
                            ans=dfs(expression.substring(start+1,i));
                        else
                            ans=dfs(expression.substring(i+1,expression.length()));
                        break;
                    }
                }
            }
            
        }
        return ans;

    }

    public String parseTernary(String expression) {
        return dfs(expression);
    }
}