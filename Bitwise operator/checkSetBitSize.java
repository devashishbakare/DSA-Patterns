//problem : https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description/?envType=daily-question&envId=2024-11-07
//editorial : https://www.youtube.com/watch?v=ai4xoI3cX-I
//code
class Solution {
    public int largestCombination(int[] candidates) {
        int maxFreq = 0;
        for(int i = 0; i < 32; i++){
            int freq = 0;
            for(int can : candidates){
                if((can & (1 << i)) != 0) freq++;
            }
            maxFreq = Math.max(maxFreq, freq);
        }
        return maxFreq;
    }
}