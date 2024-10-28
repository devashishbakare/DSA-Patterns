//problem : https://leetcode.com/problems/four-divisors/description/

// code

class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int num : nums){
            int sum = 0, count = 0;
            for(int i = 1; i * i <= num; i++){
                if(num % i == 0){
                    if(num / i == i){
                        count++;
                        sum += i;
                    }else{
                        sum += i + num/i;
                        count += 2;
                    }
                }
            }
            if(count == 4) ans += sum;
        }
        return ans;
    }
}

