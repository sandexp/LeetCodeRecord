class Solution {

    Map<String,Integer> map=new TreeMap();

    public int getTyep(char c){
        if(c>='0' && c<='9')
            return 0;
        if(c>='A' && c<='Z')
            return 1;
        if(c>='a' && c<='z')
            return -1;
        if(c=='(')
            return -2;
        if(c==')')
            return 2;
        return 3;
    }

    public void dfs(String formula ,int rate){
        Stack<Integer> stack=new Stack();
        int st=0,ed=0,type=3,num=0;
        String tmp="";
        for(int i=0;i<formula.length();i++){
            type=getTyep(formula.charAt(i));
            switch(type){
                case 0:
                    {
                        if(stack.empty()){
                            tmp=formula.substring(st,ed+1);
                            int p=i;
                            while(p<formula.length() && getTyep(formula.charAt(p))==0){
                                p++;
                            }
                            num=Integer.parseInt(formula.substring(i,p))*rate;
                            i=p-1;
                            if(map.containsKey(tmp))
                                map.put(tmp,map.get(tmp)+num);
                            else
                                map.put(tmp,num);
                        }
                    }   
                break;
                case 1:
                    {
                        if(stack.empty()){
                            st=i;
                            ed=i;
                            if(i+1==formula.length()){
                                tmp=formula.substring(i,i+1);
                                if(map.containsKey(tmp))
                                    map.put(tmp,map.get(tmp)+rate);
                                else
                                    map.put(tmp,rate);
                            }else if(getTyep(formula.charAt(i+1))==1 || getTyep(formula.charAt(i+1))==-2){
                                tmp=formula.substring(i,i+1);
                                if(map.containsKey(tmp))
                                    map.put(tmp,map.get(tmp)+rate);
                                else
                                    map.put(tmp,rate);
                            }
                        }
                    }
                break;
                case -1:
                    {
                        if(stack.empty()){
                            ed=i;
                            if(i+1==formula.length()){
                                tmp=formula.substring(i-1,i+1);
                                if(map.containsKey(tmp))
                                    map.put(tmp,map.get(tmp)+rate);
                                else
                                    map.put(tmp,rate);
                            }else if(getTyep(formula.charAt(i+1))==1 || getTyep(formula.charAt(i+1))==-2){
                                tmp=formula.substring(i-1,i+1);
                                if(map.containsKey(tmp))
                                    map.put(tmp,map.get(tmp)+rate);
                                else
                                    map.put(tmp,rate);
                            }
                        }   
                    }
                break;
                case -2:
                    {
                        stack.push(i);
                    }
                break;
                case 2:
                    {
                        int start=0;
                        if(!stack.empty())
                            start=stack.pop();
                        if(stack.empty()){
                            if(i+1>=formula.length() || getTyep(formula.charAt(i+1))!=0)
                                dfs(formula.substring(start+1,i),rate);
                            else{
                                int p=i+1;
                                while(p<formula.length() && getTyep(formula.charAt(p))==0)
                                    p++;
                                num=Integer.parseInt(formula.substring(i+1,p));
                                dfs(formula.substring(start+1,i),num*rate);
                                i=p-1;
                            }
                        }
                    }
                break;
            }
        }
    }

    public String countOfAtoms(String formula) {
        dfs(formula,1);
        StringBuffer sb=new StringBuffer();
        for(String key:map.keySet()){
            sb.append(key);
            if(map.get(key)!=1)
                sb.append(map.get(key));
        }
        return sb.toString();
    }
}