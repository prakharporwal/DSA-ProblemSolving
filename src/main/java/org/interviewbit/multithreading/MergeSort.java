package org.interviewbit.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort implements Callable<List<Integer>> {

    MergeSort(List<Integer> list){
        this.list = list;
    }
    List<Integer> list;

    @Override
    public List<Integer> call() throws Exception {
        return mergesort(list);
    }

    private static List<Integer> mergesort(List<Integer> A){
        if(A.size()<2)
            return A;
        if(A.size()==2){
            List<Integer> temp = new ArrayList<>();
            if(A.get(0) > A.get(1)){
                temp.add(A.get(1));
                temp.add(A.get(0));
            }else{
                temp.add(A.get(0));
                temp.add(A.get(1));
            }
            return temp;
        }

        int mid = A.size()/2;

        ExecutorService es = Executors.newCachedThreadPool();
        Future<List<Integer>> m1Fut =  es.submit(new MergeSort(A.subList(0,mid)));
        Future<List<Integer>> m2Fut =  es.submit(new MergeSort(A.subList(mid,A.size())));

        List<Integer> merged = new ArrayList<>();

        try{

            // merge step
            List<Integer> m1 = m1Fut.get();
            List<Integer> m2 = m2Fut.get();

            int i=0;
            int j=0;

            while(i<m1.size() && j<m2.size()){
                if(m1.get(i) < m2.get(j)) {
                    merged.add(m1.get(i));
                    i++;
                }
                else {
                    merged.add(m2.get(j));
                    j++;
                }
            }

            while(i<m1.size()){
                merged.add(m1.get(i));
                i++;
            }

            while(j<m2.size()){
                merged.add(m2.get(j));
                j++;
            }

        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }

        return  merged;
    }

}
