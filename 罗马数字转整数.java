class Solution {
    public int romanToInt(String s) {
        if(s==null)
            return 0;
        int last=1001,cur=0,second=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            cur=getNum(s.charAt(i));
            if(cur<=last){
                ans+=cur;
                last=cur;   
            }
            else{
                ans-=last;
                ans+=cur-last;
                last=cur;
            }
        }
        return ans;
    }

    public int getNum(char c){
        int ret=0;
        switch(c){
            case 'I':
            ret=1;
            break;
            case 'V':
            ret=5;
            break;
            case 'X':
            ret=10;
            break;
            case 'L':
            ret=50;
            break;
            case 'C':
            ret=100;
            break;
            case 'D':
            ret=500;
            break;
            case 'M':
            ret=1000;
        }
        return ret;
    }
}