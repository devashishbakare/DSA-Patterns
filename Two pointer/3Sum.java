link : https://leetcode.com/problems/3sum/description/

editorial : https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/

code :

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    int n = nums.length;
     for(int i = 0; i < n-2; i++){
        int low = i+1, high = n-1;
        int sum = 0 - nums[i];
         if( i == 0 || (i > 0 && nums[i] != nums[i-1])){
        
             while(low < high){
                 if(nums[low] + nums[high] == sum){
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < n-1 && low < high && nums[low] == nums[low+1]){
                        low++;
                    }
                    while(high > 0 && high > low && nums[high] == nums[high-1]){
                        high--;
                    }
                    low++;
                    high--;

                }else if(nums[low] + nums[high] < sum){
                    low++;
                }else{
                    high--;
                }
             }
                
         }
        

     }   
     return ans;
    }
}
