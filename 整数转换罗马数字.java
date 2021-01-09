class Solution {
    public String intToRoman(int num) {
        StringBuffer ans=new StringBuffer();
        int[] table=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int[] number=new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0};
        int p=0;
        while(num!=0){
            if(num-table[p]>0){
                number[p]++;
                num-=table[p];
            }else if(num-table[p]==0){
                number[p]++;
                num-=table[p];
                break;
            }else{
                p++;
            }
        }
        for(int i=0;i<number.length;i++){
            if(number[i]==0)
                continue;
            String element=map(table[i]);
            int tmp=0;
            while(tmp<number[i]){
                ans.append(element);
                tmp++;
            }
        }
        return ans.toString();
    }

    public String map(int x){
        String ans="";
        switch(x){
            case 1000:
                ans="M";
            break;
            case 900:
                ans="CM";
            break;
            case 500:
                ans="D";
            break;
            case 400:
                ans="CD";
            break;
            case 100:
                ans="C";
            break;
            case 90:
                ans="XC";
            break;
            case 50:
                ans="L";
            break;
            case 40:
                ans="XL";
            break;
            case 10:
                ans="X";
            break;
            case 9:
                ans="IX";
            break;
            case 5:
                ans="V";
            break;
            case 4: 
                ans="IV";
            break;
            case 1:
                ans="I";
            break;
        }
        return ans;
    }
}