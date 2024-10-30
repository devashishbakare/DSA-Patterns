class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n-1);
        return nums;
    }
    public void mergeSort(int nums[], int low, int high){
        if(low < high){
            int mid = low + (high-low)/2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
    }

    public void merge(int nums[], int low, int mid, int high){

        int n = mid-low+1;
        int m = high-mid;
        
        int left[] = new int[n];
        int right[] = new int[m];

        for(int i = 0; i < n; i++) left[i] = nums[i+low];
        for(int i = 0; i < m; i++) right[i] = nums[mid+1+i];
        
        int ind1 = 0, ind2 = 0;
        int index = low;
        
        while(ind1 < n && ind2 < m){
            if(left[ind1] <= right[ind2]){
                nums[index] = left[ind1];
                ind1++;
            }else{
                nums[index] = right[ind2];
                ind2++;
            }
            index++;
        }
        
        while(ind1 < n) nums[index++] = left[ind1++];
        while(ind2 < m) nums[index++] = right[ind2++];
    }
}