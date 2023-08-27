link : https://leetcode.com/contest/weekly-contest-359/problems/find-the-longest-equal-subarray/

editorial : https://www.youtube.com/watch?v=RTrSLiTOX18

code :

class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int left = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right < nums.size(); right++){
            
            map.put(nums.get(right), map.getOrDefault(nums.get(right), 0)+1);
            
            maxLength = Math.max(maxLength, map.get(nums.get(right)));
            
            if((right-left+1) - maxLength > k){
               map.put(nums.get(left), map.get(nums.get(left))-1);
               left++;
            }
            
        }
        return maxLength;
    }
}