class Solution {

    List<List<Integer>> ans=new ArrayList();
    List<Integer> template=new ArrayList();
    Set<String> set=new HashSet();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums==null)
            return null;
        Arrays.sort(nums);
        dfs(nums,0);
        return ans;
    }

    public void dfs(int[] nums,int index){
        if(index==nums.length){
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<template.size();i++)
                sb.append(template.get(i));
            if(!set.contains(sb.toString())){
                ans.add(new ArrayList(template));
                set.add(sb.toString());
            }
            return;
        }   
        template.add(nums[index]);
        dfs(nums,index+1);
        template.remove(template.size()-1);
        dfs(nums,index+1);
    }
}