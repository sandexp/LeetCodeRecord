class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed==null)
            return false;
        if(n<=0)
            return true;
        if(flowerbed.length==1)
            return flowerbed[0]==0;
        for(int i=0;i<flowerbed.length;i++){
            if(i==0){
                if(flowerbed[1]==0 && flowerbed[0]==0){
                    flowerbed[0]=1;
                    n--;
                }
            }else if(i==flowerbed.length-1){
                if(flowerbed[i-1]==0 && flowerbed[i]==0){
                    flowerbed[i]=1;
                    n--;
                }
            }else{
                if(flowerbed[i]+flowerbed[i-1]+flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    n--;
                }
            }
        }
        return n<=0;
    }
}