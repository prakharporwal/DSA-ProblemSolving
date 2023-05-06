package org.interviewbit.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MergeSortImpl {
    public static void main(String[] args) {
//        System.out.println("main " + Thread.currentThread().getId());
//
//        ExecutorService e = Executors.newFixedThreadPool(10);
//
//        Future<Integer> xFut = e.submit(new ExecutorCallable());
//        Future<Integer> yFut = e.submit(new ExecutorCallable());
//
//        try {
//            Integer x = xFut.get();
//            Integer y = yFut.get();
//            System.out.println(x + y);
//        }catch (Exception ex){
//
//        }
//
//        for(int i=1;i<=100;i++) {
//
//            Print1to100 p = new Print1to100(4);
//            Print1to100 p2 = new Print1to100(5);
//
//            Thread thread = new Thread(new Print1to100(i));
//            thread.start();
//        }

        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Integer> A = Arrays.asList(9, 31, 43, 55, 1, 2, 7,12, 4);
        Future<List<Integer>> out = es.submit(new MergeSort(A));

        try {
            List<Integer> x = out.get();
            System.out.println(out.get());

        } catch (Exception e) {

        }
    }
}
