//link : https://leetcode.com/problems/maximum-ascending-subarray-sum/description/?envType=daily-question&envId=2025-02-04

arr 5, 10, 15, 5, 10
dp  5, 15, 30, 5, 15

class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int size = nums.length;
        Integer dp[] = new Integer[size];
        for(int i = 0; i < size; i++){
            maxSum = Math.max(maxSum, getSum(i, nums, dp));
        }
        return maxSum;
    }
    public int getSum(int ind, int nums[], Integer dp[]){

        if(ind == 0) return nums[0];

        if(dp[ind] != null) return dp[ind];
        // 1 2 3
        if(nums[ind] > nums[ind-1]){
            dp[ind] = nums[ind] + getSum(ind-1, nums, dp);
        }else{
            dp[ind] = nums[ind];
        }
        return dp[ind];
    }
}