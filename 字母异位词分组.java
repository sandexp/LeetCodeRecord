class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap();
        for(int i=0;i<strs.length;i++){
            String cell=getCellString(strs[i]);
            if(!map.containsKey(cell)){
                map.put(cell,new ArrayList<String>());
            }
            map.get(cell).add(strs[i]);
        }
        List<List<String>> ans=new ArrayList();
        for(String key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }

    public String getCellString(String str){
        char[] arr=str.toCharArray();
        int size=arr.length;
        char tmp;
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(arr[j]<arr[i]){
                    tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<size;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
        
}