link : https://leetcode.com/problems/sliding-window-maximum/description/

note : 
        we want something that can give us max value, out of possible value
        we want to remove value or index which is greater but not in our range
        so index is important here, 
        I dont know that we can add index in priority queue and sort them on the basis of there value, still keeping the indexes in pq

code :

important : adding index and sorting on the basis of value, I don't know that, we can do this'

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        int ind = 0;
        //I want to add a, b as index, and sort on their value
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)-> nums[b]- nums[a]);

        for(int i = 0; i < n; i++){

            while(queue.size() > 0 && queue.peek() < i-k+1){
                queue.remove();
            }

            queue.add(i);
            if(queue.size() >= k){
                ans[ind] = nums[queue.peek()];
                ind++;
            }
        }

        return ans;

    }
}
