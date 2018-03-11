import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Request {
    public Request(int arrival_time, int process_time) {
        this.arrival_time = arrival_time;
        this.process_time = process_time;
    }

    public int arrival_time;
    public int process_time;
}

class Response {
    public Response(boolean dropped, int start_time) {
        this.dropped = dropped;
        this.start_time = start_time;
    }

    public boolean dropped;
    public int start_time;
}

class Buffer {
    public Buffer(int size) {
        this.size_ = size;
        this.finish_time_ = new ArrayList<Integer>();
    }

    public Response Process(Request request) {
        // write your code here
    	// Free buffer only when the process finished
        while (!finish_time_.isEmpty() &&
                finish_time_.get(0) <= request.arrival_time) {
            // BZ: the process finishes at i's arrival? -> finished
            //     example: S=1, n=2, A=[0,0],P=[0,1|0]
            // 1st request finishes at 0 but 2nd also comes at 0...
            finish_time_.remove(0);
            /* @Note:
             * This finally popped request has nothing to do
             * with the current new request i; i either waits
             * in queue or gets processed if idle. */
        }
        // If still full, just drop it;
        if (finish_time_.size() == size_) {
            return new Response(true, -1);
        }
        // Compute start_time and enqueue finish_time.
        // If no buffer waiting, i.e. idle, start instantly;
        // else wait at the end...
        // BZ: start_time is `at least arrival time`...
        // BZ: start_time is the finish_time popped at last?
        //     or it waits at end of queue?
        int current_start_time = finish_time_.isEmpty() ? request.arrival_time :
            finish_time_.get(finish_time_.size() - 1);
        finish_time_.add(current_start_time + request.process_time);
        return new Response(false, current_start_time);
    }

    private int size_;
    private ArrayList<Integer> finish_time_;
}

class process_packages {
    private static ArrayList<Request> ReadQueries(Scanner scanner) throws IOException {
        int requests_count = scanner.nextInt();
        ArrayList<Request> requests = new ArrayList<Request>();
        for (int i = 0; i < requests_count; ++i) {
            int arrival_time = scanner.nextInt();
            int process_time = scanner.nextInt();
            requests.add(new Request(arrival_time, process_time));
        }
        return requests;
    }

    private static ArrayList<Response> ProcessRequests(ArrayList<Request> requests, Buffer buffer) {
        ArrayList<Response> responses = new ArrayList<Response>();
        for (int i = 0; i < requests.size(); ++i) {
            responses.add(buffer.Process(requests.get(i)));
        }
        return responses;
    }

    private static void PrintResponses(ArrayList<Response> responses) {
        for (int i = 0; i < responses.size(); ++i) {
            Response response = responses.get(i);
            if (response.dropped) {
                System.out.println(-1);
            } else {
                System.out.println(response.start_time);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int buffer_max_size = scanner.nextInt();
        Buffer buffer = new Buffer(buffer_max_size);

        ArrayList<Request> requests = ReadQueries(scanner);
        ArrayList<Response> responses = ProcessRequests(requests, buffer);
        PrintResponses(responses);
    }
}
