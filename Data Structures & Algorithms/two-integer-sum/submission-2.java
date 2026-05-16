class Solution {
    public int[] twoSum(int[] nums, int target) {
       
    //Declare HashMap

    Map<Integer,Integer>hashMap = new HashMap<Integer,Integer>();
    int[] arr = new int[]{-1,-1};
    //Traverse to the Array and check for the target - nums[i]

    for(int i=0;i<nums.length;i++){
        
        if(hashMap.containsKey(target-nums[i])){
            arr[1] = i;
            arr[0] = hashMap.get(target-nums[i]);
            return arr;
        }

        hashMap.put(nums[i],i);
    }

    return arr;

    }
}
