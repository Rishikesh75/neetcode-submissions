class Solution {
    public int lengthOfLongestSubstring(String s) {
       
       Set<Character> hashSet = new HashSet<Character>();
       int i = 0;
       int j = 0;
       int len = 0;
       int maxLen = 0;
       int n = s.length();

       while(j<n){

        //ExpandWindow
        while(j<n){
            
            if(hashSet.contains(s.charAt(j))){
                maxLen = Math.max(maxLen,len);
                break;
            }
            hashSet.add(s.charAt(j));
            j++;
            len++;
        }


        //CompressWindow
        while(i<j && j<n && hashSet.contains(s.charAt(j))){

         hashSet.remove(s.charAt(i));
         i++;
         len--;   
        }

       }

       return Math.max(maxLen,len);

    }
}
