//problem : https://www.spoj.com/problems/NGIRL/

//code

public static int[] getCount(int n, int k){
		int store = n;
		n = (int)Math.sqrt(n);
		boolean prime[] = new boolean[n+1];
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i * i <= n; i++){
			if(prime[i] == false){
				for(int j = i*i; j <= n; j += i){
					prime[j] = true;
				}
			}
		}
		int count = 0;
		int choices = 0;
		for(int i = 2; i < prime.length; i++){
			if(prime[i] == false){
			    
			    if(i*i <= store) choices++; //all option
					if(i*i <= store && i*i > k) count++; //option with > k
			}
		}
		return new int[]{choices, count};
	}