class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        String ans = "";
        int j = 0;
        int n = s.length();
        HashSet<Character> hashSet = new HashSet<Character>();
        StringBuilder temp = new StringBuilder("");
        while(j<n){
            //Increase Window
            while(j<n && !hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j));
                temp.append(s.charAt(j));
                j++;
            }
            
            ans = ans.length()>temp.length() ? ans : temp.toString();

            //Decrease Window
            while(j<n &&i<j && hashSet.contains(s.charAt(j))){
                int index = temp.indexOf(String.valueOf(s.charAt(i)));
                if (index != -1) {
                    temp.deleteCharAt(index);
                }
                hashSet.remove(s.charAt(i));
                i++;
            }
        }

        return ans.length();
    }
}
