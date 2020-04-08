import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.TreeSet;
import java.util.Set;

public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        // Store the header once since the second header is identical.
        String header = null;

        // Store each record and use TreeSet for sorting by ID
        // TreeSet uses Balanced RedBlack Trees in the background for
        // O(lg(N)) insert and O(1) lookup.
        // Overall Time Complexity = O(N*lg(N))
        // Overall Space Complexity = O(N)
        Set<Record> uniqueRecords = new TreeSet<>();
        while ((line = in.readLine()) != null) {
            if (header == null) {
                // this will occur only once for the first header
                header = line;
                System.out.println(header);
            } else if(line.length() == 0) {
                // ignore the next occurance of header
                in.readLine();
            } else {
                // process the records
                String [] values = line.split(",");
                try {
                    Record record = new Record(line, Integer.parseInt(values[0]));
                    if (uniqueRecords.contains(record)) {
                        uniqueRecords.remove(record);
                    }
                    uniqueRecords.add(record);
                } catch (NumberFormatException nfe) {
                    System.out.println(" Invalid Integer ID presented");
                }
            }
        }
        for(Record record : uniqueRecords) {
            System.out.println(record);
        }
    }

    // Using comparable as Id since requirements mention that valid Integer id is
    // to be used for comparing documents
    private static class Record implements Comparable<Record> {
        private String data;
        private Integer id;

        public Record(String data, Integer id) {
            this.data = data;
            this.id = id;
        }


        @Override
        public int compareTo(Record record) {
            return Integer.compare(this.id, record.id);
        }

        @Override
        public String toString() {
            return this.data;
        }
    }
}