class Solution {
    //TC:O(N) SC:O(N)
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for(var num : nums){

            if(hashSet.contains(num))
                return true;
            
            hashSet.add(num);
        }

        return false;
    }
}