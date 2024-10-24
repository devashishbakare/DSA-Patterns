//problem : https://leetcode.com/problems/flip-equivalent-binary-trees/?envType=daily-question&envId=2024-10-24
//code
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return check(root1, root2);
    }

    public boolean check(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
       
        boolean f1 = check(root1.left, root2.left) && check(root1.right, root2.right);
        boolean f2 = check(root1.left, root2.right) && check(root1.right, root2.left);
            
        if(f1 || f2 ) return true;
        return false;
    }

}