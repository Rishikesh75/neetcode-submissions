class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for(var val : nums){
            if(set.contains(val))
                return true;
            set.add(val);
        }

        return false;
    }
}