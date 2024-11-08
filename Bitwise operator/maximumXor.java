//problem : https://leetcode.com/problems/maximum-xor-for-each-query/description/?envType=daily-question&envId=2024-11-08

//a  = b ^ c -> c = a ^ b 

//code
class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxK = ( 1 << maximumBit)-1;
        int xor = 0;
        int ans[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
            ans[nums.length-1-i] = xor ^ maxK;
        }   
        return ans;
    }
}