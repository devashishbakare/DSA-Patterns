/*
problem : https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/description/

editorial : https://www.youtube.com/watch?v=oe9HR-cLAHo&t=802s

why Greedy : 
- In this problem they told us to flip all till the end if there is 0 found and return the count
- But doing it will be O(N*N) time, it will not work

- insted of this, you can understand this, no need to flip just keep count will also work
    1 is fliped even time it will be 1 again
    0 is fliped even time it will be 0 again
    so Keeping the flipCount will tell us is current element need to be fliped or not

    below problem we have told to flip only current element is 0
    now we don't want to flip the 1 but 1 can become the 0 if flipCount is odd, same with the 0 if flip count is even then it is still be 0 so we need to flip it
    hence
    if((nums[i] == 1 && flipCount % 2 == 1) || (nums[i] == 0 && flipCount % 2 == 0)) {
        flipCount++;
    }


 */

class Solution {
    public int minOperations(int[] nums) {
        int flipCount = 0;
        for(int i = 0; i < nums.length; i++){
            if((nums[i] == 1 && flipCount % 2 == 1) || (nums[i] == 0 && flipCount % 2 == 0)) {
                flipCount++;
            }
        }   
        return flipCount;
    }
}