class Solution {

    // 中辍表达式
    public boolean isOperation(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack();
        int p=0,tmp;
        while(p<tokens.length){
            if(isOperation(tokens[p])){
                switch(tokens[p]){
                    case "+":
                    {
                        tmp=stack.pop();
                        stack.push(stack.pop()+tmp);
                    }
                    break;
                    case "-":
                    {
                        tmp=stack.pop();
                        stack.push(stack.pop()-tmp);
                    }
                    break;
                    case "*":
                    {
                        tmp=stack.pop();
                        stack.push(stack.pop()*tmp);
                    }
                    break;
                    case "/":
                    {
                        tmp=stack.pop();
                        stack.push(stack.pop()/tmp);
                    }
                    break;
                }
            }else
                stack.push(Integer.parseInt(tokens[p]));
            p++;
        }
        return stack.pop();
    }
}