link : https://leetcode.com/problems/removing-stars-from-a-string/description/

code : 
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        while(stack.size() > 0){
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }
}