class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        int p1=0,p2=1;
        List<List<Integer>> ans=new ArrayList();
        if(s.length()<3){
            return ans;
        }
        while(p1<s.length() && p2<s.length()){
            if(s.charAt(p1)!=s.charAt(p2)){
                if(p2-p1>=3){
                    List<Integer> template=new ArrayList();
                    template.add(p1);
                    template.add(p2-1);
                    ans.add(template);
                }
                p1=p2;
            }
            p2++;
        }
        if(p2-p1>=3){
            List<Integer> template=new ArrayList();
                template.add(p1);
                template.add(p2-1);
                ans.add(template);
        }
        return ans;
    }
}