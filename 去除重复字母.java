class Solution {
    public String removeDuplicateLetters(String s) {
        if(s==null)
            return null;
        if(s.length()==1)
            return s;
        int[] status=new int[26];
        int p=0;
        while(p<s.length()){
            status[s.charAt(p)-'a']++;
            p++;
        }
        Stack<Character> stack=new Stack();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            while(true){
                if(stack.contains(arr[i]))
                    break;
                if(stack.isEmpty() || stack.peek()<arr[i] || (stack.peek()>arr[i] && status[stack.peek()-'a']==0)){
                    stack.push(arr[i]);
                    break;
                }else{
                    stack.pop();
                } 
            }
            status[arr[i]-'a']--;
        }
        StringBuffer sb=new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}