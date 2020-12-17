class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList();
        List<Integer> last=new ArrayList();
        if(numRows==0)
            return ans;
        last.add(1);
        ans.add(last);
        for(int i=2;i<=numRows;i++){
            List<Integer> current=new ArrayList();
            current.add(1);
            for(int j=1;j<last.size();j++)
                current.add(last.get(j-1)+last.get(j));
            current.add(1);
            ans.add(current);
            last=current;
        }
        return ans;
    }
}