import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHuge(long n, long m) {
    /*    if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;*/
    	
    	  List<Integer> modulos = new ArrayList<>();
          modulos.add(0);
          modulos.add(1);
          int i = 0;
 
          while(! (i > 0 && modulos.get(i) == 0 && modulos.get(i + 1) == 1)) {
              modulos.add((int) ((
                      modulos.get(  i  ) % m +
                      modulos.get(i + 1) % m ) % m));
              i++;
          }
     
          
          return modulos.get((int) (n % i));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

