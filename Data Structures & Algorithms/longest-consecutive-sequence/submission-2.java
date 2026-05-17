class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<Integer>();
        
        for(var num : nums){
            hashSet.add(num);
        }
        int longestCount = 0;
        for(int i=0;i<nums.length;i++){


            if(hashSet.contains(nums[i]-1))
                continue;

            int count = 1;
            int val = nums[i];

            while(true){
                if(hashSet.contains(val+1)){
                    count++;
                    val++;
                    continue;
                }
                longestCount = Math.max(longestCount,count);
                break;
            }
        }

        return longestCount;
    }
}
