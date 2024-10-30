class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n-1);
        return nums;
    }
    public void quickSort(int nums[], int low, int high){
        if(low < high){
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot-1);
            quickSort(nums, pivot+1, high);
        }
    }
    public int partition(int nums[], int low, int high){
        
        int pivot = nums[low];
        int left = low, right = high;
        
        while(left < right){
            while(nums[left] <= pivot && left <= high-1){
                left++;
            }
            while(nums[right] > pivot && right >= low+1){
                right--;
            }
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        int temp = nums[right];
        nums[right] = nums[low];
        nums[low] = temp;
        return right;
    }

}