class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals==null || intervals.length==0){
            int[][] ans=new int[1][2];
            ans[0]=newInterval;
            return ans;
        }
        if(newInterval==null)
            return intervals;
        boolean[] status=new boolean[intervals.length];
        
        int cnt=0; 
        for(int i=0;i<intervals.length;i++){
            if(canCompact(intervals[i],newInterval)){
                intervals[i]=compact(intervals[i],newInterval);
                cnt++;
            }
        }
        if(cnt==0){
            int[][] ans=new int[intervals.length+1][2];
            for(int i=0;i<intervals.length;i++)
                ans[i]=intervals[i];
            int[] tmp=new int[2];
            ans[intervals.length]=newInterval;
            for(int i=intervals.length;i>0;i--){
                if(ans[i][0]<ans[i-1][0]){
                    tmp=ans[i];
                    ans[i]=ans[i-1];
                    ans[i-1]=tmp;
                }else{
                    break;
                }
            }
            return ans;
        }

        cnt=0;
        for(int i=1;i<intervals.length;i++){
            for(int j=0;j<i;j++){
                if(canCompact(intervals[j],intervals[i]) && status[j]==false){
                    intervals[j]=compact(intervals[i],intervals[j]);
                    status[i]=true;
                    cnt++;
                }
            }
        }

        int[][] ans=new int[intervals.length-cnt][2];
        int p=0;
        for(int i=0;i<intervals.length;i++){
            if(status[i]==false){
                ans[p]=intervals[i];
                p++;
            }
        }
        return ans;
    }

    public boolean canCompact(int[] a,int[] b){
        return !(b[1]<a[0] || a[1]<b[0]);
    }

    public int[] compact(int[] base,int[] newInterval){
        base[0]=Math.min(base[0],newInterval[0]);
        base[1]=Math.max(base[1],newInterval[1]);
        return base;
    }
    
}