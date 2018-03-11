import java.util.*;

public class GCD {
	  private static long gcd(long a, long b) {
	      while (b != 0) {
	          long r = a % b;
	          a = b;
	          b = r;
	      }
	      return a;
	  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
