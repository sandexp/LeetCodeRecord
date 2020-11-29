class Solution {
    public int[][] merge(int[][] intervals) {
        // 边界条件判断
        int size=intervals.length;
        if(size==0)
            return null;
        if(size==1)
            return intervals;
        // 合并状态位 为false表示可以合并
        boolean[] status=new boolean[size];
        int flag,cnt=0;
        int p=0;
        for(int i=0;i<size-1;i++){
            if(status[i])
                continue;

            for(int j=0;j<size;j++){
                if(i==j || status[j]==true)
                    continue;

                flag=judgeLocation(intervals[i],intervals[j]);
               
                switch(flag){
                    case -1:
                    // nop
                    break;
                    case 0:
                        intervals[i][0]= intervals[j][0]>intervals[i][0]?intervals[i][0]:intervals[j][0];
                        intervals[i][1]= intervals[j][1]>intervals[i][1]?intervals[j][1]:intervals[i][1];
                        status[j]=true;
                        cnt++;
                    break;
                    case 1:
                        intervals[i][0]= intervals[j][0]>intervals[i][0]?intervals[i][0]:intervals[j][0];
                        intervals[i][1]= intervals[j][1]>intervals[i][1]?intervals[j][1]:intervals[i][1];
                        status[j]=true;
                        cnt++;
                    break;
                }
            }
        }

        for(int i=0;i<size-1;i++){
            if(status[i])
                continue;

            for(int j=0;j<size;j++){
                if(i==j || status[j]==true)
                    continue;

                flag=judgeLocation(intervals[i],intervals[j]);
               
                switch(flag){
                    case -1:
                    // nop
                    break;
                    case 0:
                        intervals[i][0]= intervals[j][0]>intervals[i][0]?intervals[i][0]:intervals[j][0];
                        intervals[i][1]= intervals[j][1]>intervals[i][1]?intervals[j][1]:intervals[i][1];
                        status[j]=true;
                        cnt++;
                    break;
                    case 1:
                        intervals[i][0]= intervals[j][0]>intervals[i][0]?intervals[i][0]:intervals[j][0];
                        intervals[i][1]= intervals[j][1]>intervals[i][1]?intervals[j][1]:intervals[i][1];
                        status[j]=true;
                        cnt++;
                    break;
                }
            }
        }

        // 正序合并完成之后，检查剩下未合并的区间是否可以合并



        int[][] ans=new int[size-cnt][2];
        int pt=0;
        for(int i=0;i<size;i++){
            if(!status[i]){
                ans[pt]=intervals[i];
                pt++;
            }
        }
        return ans;
    }

    /**
    判断数组的相对位置
    @param a 输入数组1
    @param b 输入数组2
    @return 返回a,b关系
    表现形式为枚举值:
        -1 不相交
        0 包含(a包含b)
        1 交叉
        -2 包含(b包含a)
    */
    public int judgeLocation(int[] a,int[] b){
        if(a[1]<b[0] || a[0]>b[1])
            return -1;
        return (a[0]-b[0])*(a[1]-b[1])<=0?0:1;
    }
}