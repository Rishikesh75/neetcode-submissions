class Solution {
    public boolean hasDuplicate(int[] nums) {
        //TC:O(N) SC:O(N) 
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