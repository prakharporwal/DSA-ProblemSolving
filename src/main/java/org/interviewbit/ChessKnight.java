package org.interviewbit;

import java.util.*;

public class ChessKnight {
    public static void main(String[] args) {
        int N = 8;
        int M = 8;
        System.out.println(BFS(N, M, 1, 1, 8, 8));
    }

    public static int BFS(int N, int M, int si, int sj, int di, int dj) {

        Queue<List<Integer>> Q = new LinkedList<>();
        boolean[][] vis = new boolean[N + 1][M + 1];
        for (int r = 0; r <= N; r++) {
            for (int k = 0; k <= M; k++)
                vis[r][k] = false;
        }

        int step = 0;
        Q.add(Arrays.asList(si, sj, step));

        int[][] A = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        while (!Q.isEmpty()) {
            List<Integer> front = Q.peek();
            Q.poll();
            int i = front.get(0);
            int j = front.get(1);

            if (i < 1 || i > N || j < 1 || j > M || vis[front.get(0)][front.get(1)] == true)
                continue;
            if (front.get(0) == di && front.get(1) == dj)
                return front.get(2);

            vis[front.get(0)][front.get(1)] = true;

            for (int k = 0; k < A.length; k++) {
                Q.add(Arrays.asList(i + A[k][0], j + A[k][1], front.get(2) + 1));
                Q.add(Arrays.asList(i + A[k][1], j + A[k][0], front.get(2) + 1));
            }
        }

        return -1;
    }
}
