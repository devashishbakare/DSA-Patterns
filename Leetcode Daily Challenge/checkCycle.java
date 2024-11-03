//problem : https://leetcode.com/problems/rotate-string/description/?envType=daily-question&envId=2024-11-03

//code : 

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == goal.charAt(0)){
                if(check(goal, s, i)) return true;
            }
        }   
        return false;
    }
    public boolean check(String s1, String s2, int ind2){
        int ind1 = 0;
        while(ind1 < s1.length()){
            if(s1.charAt(ind1) == s2.charAt(ind2)){
                ind1++;
                ind2++;
            }else{
                return false;
            }
            if(ind2 >= s2.length()) ind2 = 0;
        }
        return true;
    }
}