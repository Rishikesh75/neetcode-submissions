class Solution {

    public List<List<Integer>> ans;

    private void combinationSumRecurrsion(int[] nums, int target,
                                          List<Integer> currArr,
                                          int currIndex) {

        // Base case
        if (target == 0) {
            ans.add(new ArrayList<>(currArr));
            return;
        }

        // Out of bounds or target becomes negative
        if (currIndex == nums.length || target < 0) {
            return;
        }

        // Include current element
        currArr.add(nums[currIndex]);

        // Stay at same index because we can use same element again
        combinationSumRecurrsion(nums,
                                 target - nums[currIndex],
                                 currArr,
                                 currIndex);

        // Backtracking
        currArr.remove(currArr.size() - 1);

        // Exclude current element
        combinationSumRecurrsion(nums,
                                 target,
                                 currArr,
                                 currIndex + 1);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        ans = new ArrayList<>();

        List<Integer> currArr = new ArrayList<>();

        combinationSumRecurrsion(nums, target, currArr, 0);

        return ans;
    }
}