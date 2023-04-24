link : https://leetcode.com/problems/simplify-path/description/

solution explain : https://leetcode.com/problems/simplify-path/solutions/25686/java-10-lines-solution-with-stack/?orderBy=most_votes
code : 

class Solution {
    public String simplifyPath(String path) {
        
        HashSet<String> set = new HashSet<>();
        set.add(".");
        set.add("..");
        set.add("");
        
        Stack<String> stack = new Stack();

        for(String str : path.split("/")){
            if(str.equals("..") && stack.size() > 0){
                stack.pop();
            }else{
                if(set.contains(str)== false) stack.push(str);
            }
        }
        String ans = "";
        while(stack.size() > 0){
            String str = stack.pop();
            ans = "/" + str + ans;
        }
        if(ans.length() == 0) return "/";
        return ans;
    }
}