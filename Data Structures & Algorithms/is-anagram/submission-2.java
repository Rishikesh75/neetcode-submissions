class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hashArr = new int[26];

        for(char ch : s.toCharArray()){
            hashArr[ch-'a']++;
        }

        for(char ch : t.toCharArray()){
            if(hashArr[ch-'a'] == 0)
                return false;
            hashArr[ch-'a']--;
        }

        for(int i=0;i<hashArr.length;i++){
            if(hashArr[i] !=0)
                return false;
        }

        return true;
    }
}
