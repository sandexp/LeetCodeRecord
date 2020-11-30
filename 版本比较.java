class Solution {

    public int stoi(String s){
        int radix=1;
        int ans=0;
        for(int i=s.length()-1;i>=0;i--){
            ans+=(s.charAt(i)-'0')*radix;
            radix=radix*10;
        }
        return ans;
    }

    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int pt=0,s1,s2;
        while(pt< v1.length && pt<v2.length){
            s1=stoi(v1[pt]);
            s2=stoi(v2[pt]);
            if(s1<s2)
                return -1;
            if(s1>s2)
                return 1;
            pt++;
        }
        if(pt<v1.length){
            while(pt<v1.length){
                s1=stoi(v1[pt]);
                if(s1>0)
                    return 1;
                pt++;
            }
        }
        if(pt<v2.length){
            while(pt<v2.length){
                s2=stoi(v2[pt]);
                if(s2>0)
                    return -1;
                pt++;
            }
        }
        return 0;
    }
}