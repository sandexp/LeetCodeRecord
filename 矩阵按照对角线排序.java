class Solution {
    // 辣鸡写法
    public int[][] diagonalSort(int[][] mat) {
        int size=Math.min(mat.length,mat[0].length);
        if(size==0 || size==1)
            return mat;
        int MARKER=999;
        int[] arr=new int[size+1];
        int heady=mat[0].length-1;
        int headx=0;
        int first=mat[0][mat[0].length-1];
        while(heady>=0){
            for(int i=0;i<size;i++)
                arr[i]=MARKER;
            int p=0;    
            int tmpx=headx;
            int tmpy=heady;
            int tmpx2=headx;
            int tmpy2=heady;
            while(tmpy<mat[0].length && tmpx<mat.length){
                arr[p]=mat[tmpx][tmpy];
                tmpy+=1;
                tmpx+=1;
                p++;
            }
            Arrays.sort(arr);
            p=0;
            while(tmpy2<mat[0].length && tmpx2<mat.length){
                mat[tmpx2][tmpy2]=arr[p];
                tmpy2+=1;
                tmpx2+=1;
                p++;
            }
            heady--;
        }
        if(headx<0)
            headx=1;
        while(headx<=mat.length){
            for(int i=0;i<size;i++)
                arr[i]=MARKER;
            int p=0;    
            int tmpx=headx;
            int tmpy=0;
            int tmpx2=headx;
            int tmpy2=0;
            while(tmpx<mat.length && tmpy<mat[0].length){
                arr[p]=mat[tmpx][tmpy];
                tmpy+=1;
                tmpx+=1;
                p++;
            }
            Arrays.sort(arr);
            p=0;
            while(tmpy2<mat[0].length && tmpx2<mat.length){
                mat[tmpx2][tmpy2]=arr[p];
                tmpy2+=1;
                tmpx2+=1;
                p++;
            }
            headx++;
        }
        mat[0][mat[0].length-1]=first;
        return mat;
    }
}