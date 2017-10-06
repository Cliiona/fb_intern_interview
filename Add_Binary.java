public class Add_Binary{
	/*
	 *  Dscp:
	 *       LC67 Add Binary (Leetcode原题) 
	 *  Follow up:
	 *  1.后追问改成5进制再加的结果 (无论改成X进制，需要修改的只有if(sum>X-1){....}的statement)
	 */
	public static void main(String args[])
	{
       System.out.println(addBinary("111","0")); 
       System.out.println(addFive("44024","1000"));
     }
	
	/*
	 * Add Binary:
	 * solution 1: use StringBuilder
	 * solution 2: use char[]
	 * 
	 * Q: why not use string?
	 * A: you have to copy string each time when you do concatenation.O(n)
	 * 
	 * Q: what is the best way ?
	 * A: Replace StringBuilder with char array.
	 * Q: Why?
	 * A: StringBuilder may double capacity when it hits capacity.
	 * Well, I think if we use the other constructor of StringBuilder (new StringBuilder(int size))
	 * can fix this flaw. Cuz, we know the longest length of the future string.
	 * 
	 */
	 public static String addBinary(String a, String b){
		 if(a.length()<b.length()){
			 return addBinary(b,a);
		 }
		//SOLUTION1 StringBuilder sb = new StringBuilder(a.length()+1);
		 char sb[] = new char[a.length()+1];
		 int carry = 0;
		 for(int i = a.length()-1,j = b.length()-1;i>=0;i--,j--){
			 int sum = carry;
			 carry = 0;
			 sum +=a.charAt(i)-'0';
			 sum +=j>=0?(b.charAt(j)-'0'):0;
			 if(sum>1){carry = 1;
			 sum-=2;
			 }
			 //SOLUTION1  sb.insert(0,sum);
			 sb[i+1] =(char)(sum+'0');       //i+1 非常重要，因为char array比a长一个
			 }
		 //SOLUTION1  if(carry==1)sb.insert(0, 1);
		     if(carry==1)sb[0] ='1';
		//SOLUTION1  return sb.toString();
		     return String.valueOf(sb);
	 }
	 
	 /*
	  * Followup1: 5进制
	  * 主要是 divide and mod 需要修改，其他的保持不变(修改两行)
	  */
	 public static String addFive(String a, String b){
		 if(a.length()<b.length()){
			 return addBinary(b,a);
		 }
		//SOLUTION1 StringBuilder sb = new StringBuilder(a.length()+1);
		 char sb[] = new char[a.length()+1];
		 int carry = 0;
		 for(int i = a.length()-1,j = b.length()-1;i>=0;i--,j--){
			 int sum = carry;
			 carry = 0;
			 sum +=a.charAt(i)-'0';
			 sum +=j>=0?(b.charAt(j)-'0'):0;
			 if(sum>4){carry = 1;             //edit here
			 sum-=5;                          //edit here
			 }
			 //SOLUTION1  sb.insert(0,sum);
			 sb[i+1] =(char)(sum+'0');       //i+1 非常重要，因为char array比a长一个
			 }
		 //SOLUTION1  if(carry==1)sb.insert(0, 1);
		     if(carry==1)sb[0] ='1';
		//SOLUTION1  return sb.toString();
		     return String.valueOf(sb);
	 }
	
}