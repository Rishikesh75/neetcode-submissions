class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){

            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int start = i + 1;
            int end = n-1;
            while(start<end){
                if(nums[i] + nums[start] + nums[end] == 0){
                    var val = new ArrayList<Integer>(List.of(nums[i],nums[start],nums[end]));
                    if(!ans.contains(val))
                        ans.add(val);
                    start++;
                    end--;
                }

                else if(nums[i] + nums[start] + nums[end] > 0){
                    end--;
                }

                else
                {
                    start++;
                }
            }

        }

        return ans;
    }
}
