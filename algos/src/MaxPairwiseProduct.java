import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class MaxPairwiseProduct
{
	static String getMaxPairwiseProduct(int[] numbers) {
		BigInteger result = new BigInteger("1");
		int n = numbers.length;
		
		long largest = 0;
		long secondLargest =0;

		if(numbers.length<2)
		{
			return "0";
		}
		for (int i = 0; i < n; ++i) 
		{
			if(numbers[i]>largest)
			{
				secondLargest=largest;
				largest=numbers[i];
			}
			else if(numbers[i]>=secondLargest )
			{
				secondLargest= numbers[i];
			}
		}
       
		result = result.multiply(new BigInteger(largest+""));
		result = result.multiply(new BigInteger(secondLargest+""));
		

		return result.toString();
	}
	static boolean isPalRec(String str, int s, int e)
    {
        // If there is only one character
        if (s == e)
            return true;
 
        // If first and last characters do not match
        if ((str.charAt(s)) != (str.charAt(e)))
            return false;
 
        // If there are more than two characters,
        // check if middle substring is also
        // palindrome or not.
        if (s < e+1)
            return isPalRec(str, s+1, e-1);
 
        return true;
        
    }
	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		System.out.println(getMaxPairwiseProduct(numbers));
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

	public void insert(int value) {

		if (heapSize == data.length)

			throw new HeapException("Heap's underlying storage is overflow");

		else {

			heapSize++;

			data[heapSize - 1] = value;

			siftUp(heapSize - 1);

		}

	}

	private void siftUp(int nodeIndex) {

		int parentIndex, tmp;

		if (nodeIndex != 0) {

			parentIndex = getParentIndex(nodeIndex);

			if (data[parentIndex] > data[nodeIndex]) {

				tmp = data[parentIndex];

				data[parentIndex] = data[nodeIndex];

				data[nodeIndex] = tmp;

				siftUp(parentIndex);

			}

		}

	}

}