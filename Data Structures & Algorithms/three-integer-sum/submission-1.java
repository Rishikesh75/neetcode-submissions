class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<=nums.length - 3;i++){
            
            if(i>0 && nums[i] == nums[i-1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;



            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];


                if(sum == 0)
                {
                    ans.add(List.of(nums[i],nums[j],nums[k]));

                    while(j<k && nums[j] == nums[j+1])
                        j++;
                    
                    while(j<k && nums[k] == nums[k-1])
                        k--;
                    
                    j = j + 1;
                    k = k - 1;
                } 

                else if(sum > 0)
                    k = k - 1;

                else 
                    j = j + 1;

            }
        }


        return ans;
    }
}
