public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ans=new int[deck.length];
        boolean[] status=new boolean[deck.length];
        int base=2;
        int sp=0;
        int p=0;
        int END_MARKER=1100;
        int first=0,second=0;
        while(p<deck.length){
            // 切换base,并且查询首个元素
            if(sp>=deck.length){
                for(int i=0;i<=status.length;i++){
                    if(i==status.length){
                        first=END_MARKER;
                        second=END_MARKER;
                        break;
                    }
                    if(!status[i]){
                        first=i;
                        break;
                    }
                }
                for(int i=0;i<=status.length;i++){
                    if(i==status.length){
                        second=END_MARKER;
                        break;
                    }
                    if(!status[i] && i>first){
                        second=i;
                        break;
                    }
                }
                if(first==END_MARKER && second==END_MARKER)
                    break;
                if(sp-base/2>=deck.length && first!=END_MARKER && second!=END_MARKER){
                    sp=second;
                }else{
                    sp=first;
                }
                base*=2;
            }
            ans[sp]=deck[p];
            status[sp]=true;
            p++;
            sp+=base;
        }
        return ans;
    }
}