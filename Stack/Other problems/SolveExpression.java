//Link : https://leetcode.com/problems/parsing-a-boolean-expression/description/?envType=daily-question&envId=2024-10-20

//Code:

/**
 * Everytime there is problem related to expression and brackets think in direction of the stack
 * Stack where you can keep pushing for ( 
 * and Pop it when it comes to ) 
 */

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack();
        Stack<Boolean> store;
        for(char ch : expression.toCharArray()){
            if(ch != ')'){
                stack.push(ch);
            }else{
                store = new Stack();
                while(stack.size() > 0 && 
                    stack.peek() != '!' &&
                    stack.peek() != '|' &&
                    stack.peek() != '&'
                ){
                    char tempChar = stack.pop();
                    //System.out.println(tempChar);
                    if(tempChar == 't'){
                        store.push(true);
                    }else if(tempChar == 'f'){
                        store.push(false);
                    }
                    
                }
                char op = stack.pop();
                char res = check(op, store);
                stack.push(res);
            }
        }
        return (stack.peek() == 't' ? true : false);
    }
    public char check(char op, Stack<Boolean> stack){
        if(op == '!'){   
            return (stack.pop() == true ? 'f' : 't');
        }else if(op == '&'){
            boolean flag = true;
            while(stack.size() > 0){
                boolean ele = stack.pop();
                flag = flag && ele;
            }
            return (flag == true ? 't' : 'f');
        }else if(op == '|'){
            boolean flag = false;
            while(stack.size() > 0){
                boolean ele = stack.pop();
                flag = flag || ele;
            }
            return (flag == true ? 't' : 'f');
        }else{
            return 't';
        }
        
    }
}