class Solution {
    
    List<Integer> template=new ArrayList();

    List<List<Integer>> ans=new ArrayList();
    Set<String> set=new HashSet();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,1,k);
        return ans;
    }

    public void dfs(int n,int k,int start,int size){
        if(k==0 || start>n){
            if(template.size()==size){
                StringBuffer sb=new StringBuffer();
                for(int i=0;i<template.size();i++){
                    sb.append(template.get(i));
                }
                if(!set.contains(sb.toString())){
                    set.add(sb.toString());
                    ans.add(new ArrayList<>(template));
                }
            }
            return;
        }
        template.add(start);
        dfs(n,k-1,start+1,size);
        template.remove(template.size()-1);
        dfs(n,k,start+1,size);
    }
}