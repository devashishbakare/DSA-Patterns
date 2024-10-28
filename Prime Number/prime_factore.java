// calculate the prime factors of the number
//72 -> 2 * 2 * 2 * 3 * 3
public static Map<Integer, Integer> map;
public static void main(String[] args) {
 	  map = new HashMap<>();
 	  primeFactor(15); 
}	
public static void primeFactor(int n){
 	 
 	   if(n == 1) return;
 	   
 	   for(int i = 2; i * i < n; i++){
 	       
 	       if( n % i == 0){
 	           int count = 0;
 	           while(n % i == 0){
 	               count++;
 	               n = n / i;
 	           }
 	           map.put(i, count);
 	       }
 	       
 	   }
 	   if( n > 1) map.put(n, 1);
}	