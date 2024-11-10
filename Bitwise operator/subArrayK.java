//problem : https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/description/?envType=daily-question&envId=2024-11-10

//code : 

class Solution {
    public static int removeElement(int x,int arr[]) {
         int i = 0;
         int a = 0;
         while(x>0) {
            if((x&1)==1) {
                if(arr[i]==1) {
                   a = a + (int)Math.pow(2,i);
                } 
                arr[i]--;
            }
            i++;
            x = x>>1;
         }
         return a;
    }
    public static void addElement(int arr[],int x) {
        int i = 0;
        while(x>0) {
          if((x&1)==1) {
            arr[i]++;
          }
          x = x>>1;
          i++;
        }
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int arr[] = new int[32];
        int ans = Integer.MAX_VALUE;
        int x = 0;
        while(j<nums.length) {
            if(j==0) {
              x = nums[j];
              addElement(arr,nums[j]);
            } else {
                x = x | nums[j];
                addElement(arr,nums[j]);
            }
           while(i<=j && x>=k) {
              ans = Math.min((j-i)+1,ans);
              x = x - removeElement(nums[i],arr);
              i++;
           }
           j++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}