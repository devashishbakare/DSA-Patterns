link : https://leetcode.com/problems/minimum-size-subarray-sum/description/

editorial : https://leetcode.com/problems/minimum-size-subarray-sum/editorial/

code :

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = (int)1e9;   
        int start = 0, end = 0, n = nums.length;
        int sum = 0;
        while(start < n && end < n){
            sum += nums[end];
            while(sum >= target){
                int len = end - start +1;
                minLen = Math.min(minLen, len);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return (minLen == (int)1e9 ? 0 : minLen);
    }
}