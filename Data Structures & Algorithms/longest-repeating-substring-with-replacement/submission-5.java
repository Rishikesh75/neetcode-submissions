class Solution {
    public int characterReplacement(String s, int k) {

       int i = 0;
       int j = 0;
       int n = s.length();
       int maxFreq = 0;
       int[] freq = new int[26];
       int maxLen = 1;
       for(;j<n;j++){

        freq[s.charAt(j)-'A']++;

        maxFreq = Math.max(maxFreq,freq[s.charAt(j)-'A']);

        int repetions = (j - i + 1) - maxFreq;

        if(repetions > k){
            freq[s.charAt(i)-'A']--;
            i++;
        }

        maxLen = Math.max(j-i+1,maxLen);
       }

       return maxLen;
    }
}