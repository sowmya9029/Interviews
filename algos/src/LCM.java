import java.util.*;

public class LCM {
  private static long lcm(int a, int b) {
//    for (long l = 1; l <= (long) a * b; ++l)
//      if (l % a == 0 && l % b == 0)
//        return l;
//
//    return (long) a * b;
	  return ((long) a * b) / gcd(a, b);
  }



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

    System.out.println(lcm(a, b));
  }
}
