//link : https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/?envType=daily-question&envId=2025-01-12

//editorial : https://youtu.be/8Svn_u41rt8?si=ZNUVQ323unSnIGz9

//code
class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 == 1) return false;
        int o = 0, c = 0, w = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            char status = locked.charAt(i);
            if(status == '0') {
                w++;
                if(o + w < c) return false;
                continue;
            }
            if(ch == '(') o++;
            else c++;
            if(o + w < c) return false;
        }
        o = 0;
        c = 0;
        w = 0;
        for(int i = s.length()-1; i>= 0; i--){
            char ch = s.charAt(i);
            char status = locked.charAt(i);
            if(status == '0') {
                w++;
                if(c + w < o) return false;
                continue;
            }
            if(ch == '(') o++;
            else c++;
            if(c + w < o) return false;
        }

        return true;

    }
}