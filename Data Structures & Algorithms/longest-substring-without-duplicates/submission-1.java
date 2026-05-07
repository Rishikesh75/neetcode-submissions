class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();

        int i = 0;
        int j = 0;
        int len = 0;
        int maxLen = 0;
        int n = s.length();

        while(j<n){

            //expandWidow
            while(j<n){
                if(hashSet.contains(s.charAt(j))){
                    maxLen = Math.max(maxLen,len);
                    break;
                }
                hashSet.add(s.charAt(j));
                len++;
                j++;
            }

            //CompreessWindow
            while(i<j && j<n && hashSet.contains(s.charAt(j))){
                hashSet.remove(s.charAt(i));
                len--;
                i++;
            }
        }
        
        maxLen = Math.max(maxLen,len);
        return maxLen;

    }
}
