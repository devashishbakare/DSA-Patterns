//problem : https://leetcode.com/problems/maximal-rectangle/

//code

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int ans = 0;
        int store[] = new int[colLen];
        for(int row = 0; row < rowLen; row++){
            for(int col = 0; col < colLen; col++){
                if(matrix[row][col] == '1'){
                    store[col] = store[col] + 1;
                }else{
                    store[col] = 0;
                }
            }
            ans = Math.max(largestRectangleArea(store),ans);
        }
        return ans;
    }
     public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int n = heights.length;
        int max = 0;
        for(int i = 0; i < n; i++){

            while(stack.size() > 0 && heights[stack.peek()] >= heights[i]){
                int currIndex = stack.pop();
                int width = (stack.size() == 0 ? i : (i - stack.peek()-1));
                max = Math.max(max, heights[currIndex] * width);
            }
            stack.push(i);
        }

        while(stack.size() > 0){
            int currIndex = stack.pop();
            int width = (stack.size() == 0 ? n : (n-stack.peek()-1));
            max = Math.max(max, heights[currIndex] * width);
        }
        return max;

    }
}