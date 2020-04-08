import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine())
        {
            String line = s.nextLine();
            sortLine(line);
        }
    }
    private static void sortLine(String line)
    {
        String[] array = line.split(" ");
        Double[] double_array = new Double[array.length];
        for(int i =0;i<array.length;i++)
        {
            double_array [i] = Double.parseDouble(array[i]);
        }
        Arrays.sort(double_array);
        for(int i =0;i<double_array.length;i++)
        {
           System.out.print(double_array);
           System.out.print(" ");
        }
        System.out.println();
    }
}
