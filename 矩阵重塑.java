class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int total=nums.length*nums[0].length;
        if(total==0)
            return nums;
        if(r*c!=total)
            return nums;
        List<Integer> list=new ArrayList();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                list.add(nums[i][j]);
            }
        }
        int[][] ans=new int[r][c];
        int p=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans[i][j]=list.get(p);
                p++;
            }
        }
        return ans;
    }
}