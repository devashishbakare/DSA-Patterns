link : 
https://leetcode.com/problems/valid-parentheses/

Note : there are a lot of edge cases we have to handle, check it once
code : 

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        if(s.length() == 1) return false;
        for(int i = 0; i < s.length(); i++){
            char brace = s.charAt(i);
            if(brace == '{' || brace == '(' || brace == '[') {
                stack.push(brace);
            }else{
                if(stack.size() == 0) return false;
                if((brace == '}' && stack.peek() == '{') ||
                 (brace == ')' && stack.peek() == '(') ||
                  (brace == ']' && stack.peek() == '[') ){
                      stack.pop();
                  }else{
                      return false;
                  }
            }
        }
        if(stack.size() != 0)
        return false;

        return true;
    }
}