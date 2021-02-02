class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] list=preorder.split(",");
        if(list[0].equals("#")){
            if(list.length==1)
                return true;
            else
                return false;
        }
        Stack<Integer> stack=new Stack();
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<list.length;i++){
            if(stack.empty()){
                if(i==0){
                    stack.push(i);
                    map.put(i,0);
                    continue;
                }else
                    return false;
            }
            if(list[i].equals("#")){
                map.put(stack.peek(),map.get(stack.peek())+1);
                while(!stack.empty() && map.get(stack.peek())>=2){
                    map.put(stack.pop(),0); 
                    if(!stack.empty())
                        map.put(stack.peek(),map.get(stack.peek())+1);
                }
            }else{
                map.put(i,0);
                stack.push(i);
            }
        }
        return stack.empty();
    }
}