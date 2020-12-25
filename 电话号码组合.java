class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null)
            return null;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> ans=new ArrayList();
        if(digits.length()==0)
            return ans;
        dfs(digits,0,phoneMap,new StringBuffer(),ans);
        return ans;
    }

    public void dfs(String str,int index,Map<Character,String> mapping,StringBuffer sb,List<String> ans){
        if(index==str.length()){
            ans.add(sb.toString());
            return;
        }
        String tmp=mapping.get(str.charAt(index));
        for(int i=0;i<tmp.length();i++){
            sb.append(tmp.charAt(i));
            dfs(str,index+1,mapping,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}