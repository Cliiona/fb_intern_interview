public class Fibonacci{
	/*Dscp:
	 * 2017年3月
	 * 求Fibonacci数列的第n个数 F(1) = 1, F(2) = 1, F(3) = 2, F(4) = 3 ... ... 求F(n)的值
	 */
	
	/*
	 * @param: n 
	 * solution 1: DP (memorization Array) TIME:O(n) SPACE:O(n)
	 * solution 2: use two int variable TIME: O(1) SPACE:(1) better~  
	 */
	
	public static int fibonacci1(int n){
		int opt[] = new int[n];
		if(n<2)return 1;
		opt[0] = 1; opt[1] = 1;
		for(int i = 2; i < n; i++){
			opt[i] = opt[i-1] + opt[i-2];
		}
		return opt[n-1];
 	}
	
	public static int fibonacci2(int n){
		int now = 1,prev =1, prevp = 1;
		for(int i = 2; i < n; i++){
			now = prev + prevp;
			prevp = prev;
			prev = now;
		}
		return now;
	}
	
	public static void main(String args[])
	{
       System.out.println(fibonacci1(5)); 
     }
}