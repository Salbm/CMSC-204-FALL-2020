package lab;

public class ArraySum {

	private int result;

	public int sumOfArray(Integer[] Array, int k) {
		
	     if (k == 0) { 
	    	 
	         result = 0;
	     }
	     else {
	    	 
	    	 result = Array[k-1] + sumOfArray(Array,(k-1));
	     }
	     return result;
	}
	
	 public int fibonacci(int x) {
		
		 if ((x == 0) || (x == 1))
		 {
	         return x; 
		 }
		 else {
			
			 return fibonacci(x- 1) + fibonacci(x - 2);
		 }
	 }
}