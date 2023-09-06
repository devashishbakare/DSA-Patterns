link : https://leetcode.com/problems/contiguous-array/description/

Logic : 

// there are only 0 and 1 are there
// if we treat 0 as -1, and keep the sum, and if sum == 0 means we have equal number of 0 and 1
// if sum is repeating mean till that sum to next repeated sum there are equal number of 0 and 1's

code :

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        map.put((long)0, -1);
        long sum = 0;
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                sum -= 1;
            }else{
                sum += 1;
            }

            if(map.containsKey(sum)){
                int index = map.get(sum);
                maxLength = Math.max(maxLength, i-index);
            }else{
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}