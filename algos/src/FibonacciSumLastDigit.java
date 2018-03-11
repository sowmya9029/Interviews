import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSum(long n) {
        
        
    	if(n<2){
			return (int)n;
		}
		
		int m = 10;
        int[] arr = new int[100];
		arr[0] = 0;
		arr[1] = 1;
		int i=2;
		for(; i<=n; ++i){
			arr[i] = (arr[i-1] + arr[i-2])%(m);
			
			if(arr[i] == 0 && arr[i-1] == 1){
				break;
			}
		}
		--i;
	
		long offset = (long)(n+1)/(i+1);
	
		n = (n+1)%(i+1);
		int sum = 0;
		for(int a=0; a<=i; ++a){
			sum += ((long)arr[a]*offset)%10;
		}
	
	
		for(int a=0; a<n; ++a){
			sum += arr[a]%10;
		}
	
		return sum%10;
    }
//  private static long getFibonacciSum(long n) {
//      if (n <= 1)
//          return n;
//
//      long previous = 0;
//      long current  = 1;
//      long sum      = 1;
//
//      for (long i = 0; i < n - 1; ++i) {
//          long tmp_previous = previous;
//          previous = current;
//          current = tmp_previous + current;
//          sum = (sum + (current)) % 10;
//      }
//
//      return sum;
//  }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}

