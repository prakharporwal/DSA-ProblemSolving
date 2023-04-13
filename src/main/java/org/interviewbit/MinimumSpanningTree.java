package org.interviewbit;

import java.util.*;

public class MinimumSpanningTree {
    public static void main(String[] args) {

    }

    public static int solve(int A, int[][] B) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue(Collections.reverseOrder());
        List<List<List<Integer>>> G = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            G.set(B[i][0], new ArrayList<>() );
        }

        for(int i=0;i<G.get(0).size();i++){
            pq.add(new ArrayList<>());
        }

        while(!pq.isEmpty()){
            List<Integer> temp = pq.peek();
            pq.poll();

            for(int i=0;i<G.size();i++){

            }
        }
        return 0;
    }
}
