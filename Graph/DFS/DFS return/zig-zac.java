link : https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/

editorial : https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/editorial/


this problem will trickle you what to return and how should I process with dfs call
definitely its challenging and get your eyes on this once

code :

class Solution {
    int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        //-1 denote left call is done now we have to right side
        dfs(root, -1, 0);
        dfs(root, -2, 0);
        return maxLength;
    }

    public void dfs(TreeNode root, int lastCall, int steps){

        if(root == null) return;

        maxLength = Math.max(steps, maxLength);
        //if lastcall is -1 then we have to to right with +1 steps
        if(lastCall == -1){
            dfs(root.right, -2, steps+1);
            dfs(root.left, -1, 1);
        }else{
            dfs(root.left, -1, steps+1);
            dfs(root.right, -2, 1);
        }

    }


}









