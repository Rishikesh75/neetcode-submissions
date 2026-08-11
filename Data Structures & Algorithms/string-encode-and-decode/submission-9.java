class Solution {

    //TC:O(N)
    public String encode(List<String> strs) {
       String result = "";

       for(var str : strs){
            result = result + str.length() +  "@" + str ;
       }

       return result;
    }

    //TC:O(N)
    public List<String> decode(String str) {

        List<String> ans = new ArrayList<>();
        int n = str.length();
        int i=0;
        while(i<n){
            int j = i;
            while(str.charAt(j)!='@'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            int start = j+1;
            int end = start + len;

            ans.add(str.substring(start,end));

            i = end;
        }

        return ans;
    }
}