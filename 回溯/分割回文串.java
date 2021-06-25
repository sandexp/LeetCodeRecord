class Solution {

    List<List<String>> ans=new ArrayList();

    /**
        表示start->end 区间所有划分方式
        [start, end]
     */
    public void dfs(String s, int start,int end,List<String> list){
        if(start>end){
            ans.add(new ArrayList(list));
            return;
        }
        String t=s.substring(start,end+1);
        int p1=0,p2=0;
        while(start+p2<=end){
            String tmp=t.substring(p1,p2+1);
            if(isLegal(tmp)){
                list.add(tmp);
                dfs(s,start+p2+1,end,list);
                list.remove(list.size()-1);
            }
            p2++;
        }
    }

    private boolean isLegal(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0)
            return ans;
        dfs(s,0,s.length()-1,new ArrayList());
        return ans;
    }
}