class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){

            if(i>0 && nums[i] == nums[i-1])
                continue;
            int left = i+1;
            int right = n-1;

            while(left<right)
            {
                int sum = nums[left] + nums[i] + nums[right];

                if(sum == 0){
                    var val = new ArrayList<>(List.of(nums[left],nums[i],nums[right]));
                    if(!list.contains(val))
                        list.add(val);
                    left++;
                    right--;
                    continue;
                }

                else if(sum>0)
                    right--;
                
                else 
                    left++;
            }
        }

        return list;

    }
}
