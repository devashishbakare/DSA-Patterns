
/*
The Idea is if nums[i] > nums[i+1] meaning,
current element is bigger then next element then we have to push that element to the right side of array
*/
class Solution {
    public int[] sortArray(int[] nums) {
        int size = nums.length;
        for(int i = 0; i < size-1; i++){
            for(int j = 0; j < size-1-i; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}

//problem related to bubble sort
//problem : https://leetcode.com/problems/find-if-array-can-be-sorted/description/?envType=daily-question&envId=2024-11-06

//code
class Solution {
    public boolean canSortArray(int[] nums) {
        
        int size = nums.length;
        for(int i = 0; i < size-1; i++){
            for(int j = 0; j < size-1-i; j++){
                if(nums[j] > nums[j+1]){
                    if(getCount(nums[j]) == getCount(nums[j+1])){
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public int getCount(int n){
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}