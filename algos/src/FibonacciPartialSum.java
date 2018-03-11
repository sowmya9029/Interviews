import java.util.*;

public class FibonacciPartialSum {
//    private static long getFibonacciPartialSumNaive(long from, long to) {
//        long sum = 0;
//
//        long current = 0;
//        long next  = 1;
//
//        for (long i = 0; i <= to; ++i) {
//            if (i >= from) {
//                sum += current;
//            }
//
//            long new_current = next;
//            next = next + current;
//            current = new_current;
//        }
//
//        return sum % 10;
//    }
    
    
    private static long getFibonacciPartialSumfast(long m, long n)
    {
    	if(n<2){
			return (int)n;
		}
		
		int mm = 10;
        int[] arr = new int[100];
		arr[0] = 0;
		arr[1] = 1;
		int i=2;
		for(; i<=100; ++i){
			arr[i] = (arr[i-1] + arr[i-2])%(mm);
			
			if(arr[i] == 0 && arr[i-1] == 1){
				break;
			}
		}
		--i;
	
		
		long offset = (long)(n-m+1)/(i+1);
		
		//n = (n-m+1)%(i+1);
		int sum = 0;
		for(int a=0; a<=i; ++a){
			sum += ((long)arr[a]*offset)%10;
		}
	
		n -= (i+1)*offset;
	
		for(long a=m; a<=n; ++a){
			sum += arr[(int)(a%(i+1))];
		}
		
		return sum%10;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumfast(from, to));
    }
}

