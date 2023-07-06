link : https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

code : 

class Solution {
    public int longestSubarray(int[] nums) {
     int start = 0;
     int end = 0;
     int n = nums.length;
     int sum = 0, ans = 0;
     //[0,1,1,1,0,1,1,0,1]
     //start = 1
     //end = 7
     //sum = 5
     //len = 6
     //ans = 5
     while(start < n && end < n){

         if(nums[end] == 1) sum++;
    
        int len = end-start+1;
         if(len-sum > 1){
             if(nums[start] == 1) sum--;
             start++;
         }else{
             
             ans = Math.max(ans, len);
             
         }
         end++;
        
     }  
     return ans-1; 
    }
}