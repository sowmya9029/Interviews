package com.algos.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class StreamMedian {

        /** initialize your data structure here. */
        PriorityQueue<Integer> max_pq;
        PriorityQueue<Integer> min_pq;
        public StreamMedian() {
            max_pq = new PriorityQueue<>();
            min_pq = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {

            if(!max_pq.isEmpty() && min_pq.peek()>num)
            {
                min_pq.add(num);
            }
            else
            {
                max_pq.add(num);
            }
            System.out.println("median::"+findMedian());
        }

        public double findMedian() {
            if(max_pq.size()==min_pq.size())
            {
                return (max_pq.peek()+min_pq.peek())/2;
            }
            else
            {
                return min_pq.size()>max_pq.size()?min_pq.peek():max_pq.peek();
            }
        }
    public static void main(String arg[])
    {

    }
}
