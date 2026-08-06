class Solution {
    //TC:o(N^2)
    //SC:O(N)
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(var num : nums){
            if(hashSet.contains(num)){
                return true;
            }

            hashSet.add(num);
        }

        return false;
    }
}