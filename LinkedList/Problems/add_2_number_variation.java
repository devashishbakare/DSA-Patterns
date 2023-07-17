link : https://leetcode.com/problems/add-two-numbers-ii/description/


editorial : https://leetcode.com/problems/add-two-numbers-ii/editorial/

code : 

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       List<Integer> first = new ArrayList<>();
       List<Integer> sec = new ArrayList<>();
       ListNode temp1 = l1;
       while(temp1 != null){
           first.add(temp1.val);
           temp1 = temp1.next;
       } 

       ListNode temp2 = l2;
       while(temp2 != null){
           sec.add(temp2.val);
           temp2 = temp2.next;
       } 

        Collections.reverse(first);
        Collections.reverse(sec);


        List<Integer> res = new ArrayList<>();
        int ind1 = 0, ind2 = 0, carry = 0;

        while(ind1 < first.size() && ind2 < sec.size()){
            System.out.println(first.get(ind1) + " - "+sec.get(ind2));
            int sum = first.get(ind1++) + sec.get(ind2++) + carry;
            
            carry = sum / 10;
            System.out.println("sum " +sum +" carry "+carry +" val "+sum%10);
            res.add(sum%10);
        }

        if(ind1 >= first.size() && ind2 >= sec.size() && carry > 0){
            res.add(carry);
            carry = 0;
        }

        while(ind1 < first.size()){
           int newSum = first.get(ind1++) + carry;
           carry = newSum / 10;
           res.add(newSum%10);
        }
       
        if(ind1 >= first.size() && ind2 >= sec.size() && carry > 0){
            res.add(carry);
            carry = 0;
        }
    
        while(ind2 < sec.size()){
           int newSum = sec.get(ind2++) + carry;
           carry = newSum / 10;
           System.out.println("sum " +newSum +" carry "+carry +" val "+newSum%10);
           res.add(newSum%10);
        }
         
        if(ind1 >= first.size() && ind2 >= sec.size() && carry > 0){
            res.add(carry);
            carry = 0;
        }

        

        Collections.reverse(res);

        ListNode temp = new ListNode(0);
        ListNode ans = temp;

        for(int val : res){
            // System.out.println(val);
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return ans.next;
    }

   
}
