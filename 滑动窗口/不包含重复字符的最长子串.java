class Solution {

    /**
    滑动窗口, 当遇到重复值的时候, 窗口最右侧是重复值, 此时 窗口的左指针指向 
    上一个重复值的位置的下一个
    这样就构造出一个新的不重复的字符串
    更新操作发生在这个时候

     */
    public int lengthOfLongestSubstring(String s) {

        if(s.length()<2){
            return s.length();
        }

        int maxn=0;
        int left=0,right=0;
        Map<Character,Integer> map=new HashMap();
        
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                maxn=Math.max(maxn,right-left);

                int lastIndex= map.get(s.charAt(right));
                for(int i=left;i<=lastIndex;i++){
                    map.remove(s.charAt(i));
                }
                left=lastIndex+1;
            }
            map.put(s.charAt(right),right);
            right++;
        }
        return Math.max(maxn,map.size());
    }
}