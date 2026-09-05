class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if(nums.length == 0) return 0;
        for(var num : nums){
            hashSet.add(num);
        }   
        int maxLen = 1;

        for(var num : nums){
            if(hashSet.contains(num-1))
                continue;
            
            int i = num+1;
            for(;;i++){
                if(!hashSet.contains(i))
                    break;
            }
            maxLen= Math.max(i - num,maxLen);
        }
        return maxLen;
    }
}
