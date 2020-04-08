//package com; /**
// * Copyright 2018 Expedia, Inc. All rights reserved.
// * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
// */
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Set;
//
///**
// * Created by srkonduri on 7/22/18.
// */
//public class Airbnb {
//    // Complete the paginate function below.
//
//    static List<String> paginate(int num, List<String> results) {
//        List<String> result = new ArrayList<>();
//        List<String> buffer = new ArrayList<>();
//        Set<Integer> currentHosts = new HashSet();
//        double numberOfPages = results.size()/num;
//        int pageCount = 0;
//        double pages = 0;
//        while(pages < numberOfPages) {
//            for(int i=0;i<results.size();) {
//                String key = results.remove(i);
//                String [] hosts = key.split(",");
//                int host = Integer.parseInt(hosts[0]);
//                if(currentHosts.add(host)) {
//                    result.add(key);
//                    pageCount++;
//                } else {
//                    buffer.add(key);
//                }
//                if(pageCount == num) {
//                    pageCount = 0;
//                    pages++;
//                    currentHosts = new HashSet();
//                    result.add("");
//                    buffer.addAll(results);
//                    results.clear();
//                }
//            }
//            results.addAll(buffer);
//            buffer.clear();
//            currentHosts.clear();
//
//        }
//        result.addAll(results);
//        return result;
//    }
//
//    public static void main(String [] args) {
//        Scanner s = new Scanner(System.in);
//        List<String> input = new ArrayList<>();
//        int num = s.nextInt();
//        int size = s.nextInt();
//        while(input.size() <= size) {
//            input.add(s.nextLine());
//        }
//        input.remove(0);
//        System.out.println(paginate(num,input));
//    }
//
//}
//
////telephonic interview
//  wizards (dijkstra,dynamic)
//
//
