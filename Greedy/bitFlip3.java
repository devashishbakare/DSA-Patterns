/*
problem : https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/description/?envType=daily-question&envId=2024-06-24

editorial : https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/editorial/?envType=daily-question&envId=2024-06-24
Vedio explanation : https://www.youtube.com/watch?v=oe9HR-cLAHo&t=802s
 */

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flipTracker[] = new int[n];
        int flipCount = 0, ans = 0;
        for(int i = 0; i < n; i++){
            if(i >= k){
                if(flipTracker[i-k] > 0) flipCount -= flipTracker[i-k];
            }

            if((nums[i] == 0 && flipCount % 2 == 0) || (nums[i] == 1 && flipCount % 2 == 1)){
                if(i + k > n) return -1;
                ans++;
                flipCount++;
                flipTracker[i] = 1;
            }
        }
        return ans;
    }
}