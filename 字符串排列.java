class Solution {

    List<String> res=new LinkedList();
    char[] c;

    public String[] permutation(String s) {
        Set<String> set=new HashSet();
        c=s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    // x表示第x位选择第i-1位需要在选择第i位的情况下进行
    public void dfs(int x){
        if(x==c.length-1){
            // 添加最后一个元素
            res.add(String.valueOf(c));
            return;
        }
        Set set=new HashSet();
        for(int i=x;i<c.length;i++){
            if(set.contains(c[i])) 
                continue;
            set.add(c[i]);
            // 使用当前位置的元素
            swap(i,x);
            // 选择下一级
            dfs(x+1);
            // 不使用当前的元素
            swap(i,x);
        }
    }

    public void swap(int x,int y){
        char tmp;
        tmp=c[x];
        c[x]=c[y];
        c[y]=tmp;
    }
}