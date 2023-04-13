package org.interviewbit;

import java.util.*;

public class MinCostPathInMatrix {
    public static void main(String[] args) {
        int N=3;
        int M=3;
        ArrayList<String> C = new ArrayList<>(Arrays.asList("RRR","DDD","UUU"));
        System.out.println(solve(N,M,C));
    }

    private static int helper(int si,int sj,int N,int M, ArrayList<String> C,int[][] cost){

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(0).compareTo(o2.get(0))==0){
                    return o1.get(1).compareTo(o2.get(1));
                }
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        pq.add(Arrays.asList(0,si,sj));

        cost[si][sj]=0;

        while (!pq.isEmpty()) {
            List<Integer>  top = pq.peek();
            pq.poll();
            int i = top.get(1);
            int j = top.get(2);

            int u = 1, d = 1, l = 1, r = 1;
            if (C.get(i).charAt(j) == 'U')
                u = 0;
            if (C.get(i).charAt(j) == 'D')
                d = 0;
            if (C.get(i).charAt(j) == 'L')
                l = 0;
            if (C.get(i).charAt(j) == 'R')
                r = 0;

            if(i-1>=0 && cost[i][j] + u < cost[i-1][j]) {
                cost[i-1][j] =  u + cost[i][j];
                pq.add(Arrays.asList(cost[i-1][j],i-1,j));
            }

            if(j-1>=0 && cost[i][j] + l < cost[i][j-1]) {
                cost[i][j-1] = l + cost[i][j];
                pq.add(Arrays.asList(cost[i][j-1],i,j-1));
            }

            if(i+1<N && cost[i][j] + d < cost[i+1][j]) {
                cost[i+1][j] = d + cost[i][j];
                pq.add(Arrays.asList(cost[i+1][j],i+1,j));
            }

            if(j+1<M && cost[i][j] + r < cost[i][j+1]) {
                cost[i][j+1] = r + cost[i][j];
                pq.add(Arrays.asList(cost[i][j+1],i,j+1));
            }
        }

        return cost[N-1][M-1];
    }

    private static int solve(int N, int M, ArrayList<String> C){
        int[][] cost = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                cost[i][j] = Integer.MAX_VALUE;
        }

        return helper(0,0,N,M,C,cost);
    }
}
