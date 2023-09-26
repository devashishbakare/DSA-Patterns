link : https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/?envType=daily-question&envId=2023-09-20

editorial : https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/solutions/2136570/change-your-perspective-java-explanation/?envType=daily-question&envId=2023-09-20

code : 

class Solution {
    public int minOperations(int[] nums, int x) {
        long sum = 0;
        for(int num : nums) sum += num;
        sum = sum - x;
        int maxLane = -1;
        long currSum = 0;
        for(int left = 0, right = 0; right < nums.length; right++){
            currSum += nums[right];
            while(left <= right && currSum > sum){
                currSum = currSum - nums[left];
                left++;
            }
            if(currSum == sum){
                maxLane = Math.max(maxLane, right-left + 1);
            }
        }
        return maxLane == -1 ? -1 : nums.length-maxLane;
    }
}