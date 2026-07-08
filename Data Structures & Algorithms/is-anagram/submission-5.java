class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] hashArr = new int[26];

        for(var ch : s.toCharArray()){
            hashArr[(int)(ch-'a')]++;
        }

        for(var ch : t.toCharArray()){
            if(hashArr[(int)ch-'a'] == 0) return false;
            hashArr[(int)(ch-'a')]--;
        }

        return true;
    }
}
