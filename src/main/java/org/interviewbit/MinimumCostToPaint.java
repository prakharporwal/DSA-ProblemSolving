package org.interviewbit;

public class MinimumCostToPaint {
    public static void main(String[] args) {
        //R[1,2,3,4,5]
        //B[4,5,3,2,1]
        //G[2,3,4,5,2]
        int[][] A = {
                {1,2,3,4,5},
                {4,5,3,2,1},
                {2,3,4,5,2}
        };

        int[][] B = {
                {1,4,2},
                {2,5,3},
                {3,3,4},
                {4,2,5},
                {5,1,2}
        };

        // 1+3+3+2+2 = 11
        System.out.println(minimumCost(B));
    }


    // nx3 matrix
    // cost = +ve
    //
    // min of the next idx to me -> n
    //
    // 3(n-1) + 2*(n-2) + 2*(n-1) + === > (2^n)
    // repeating recursion
    // dynamic prog.
    // dp[i][0] -> min-cost( Red  + matrix started from index i)
    // dp[i][1] = -> blue;
    // O(n*3)
    //
    // j is for color from 0 < j < 2

    // dp[i][j] = cost[i][0] + min(dp[i+1][1], dp[i+1][2]);
    // dp[n-1][j] = cost[n-1][j]
    // final ans =
    // min (dp[0][0],dp[0][1], dp[0][2]);

    //  time -> O(n*3) * O(1) => O(n);
    private static int minimumCost(int[][] cost){
        int n = cost.length;
        int[][] dp = new int[n][3];

        for(int i=n-1; i>=0 ; i--) {
            if (i == n - 1) {
                //base case
                dp[n - 1][0] = cost[i][0];
                dp[n - 1][1] = cost[i][1];
                dp[n - 1][2] = cost[i][2];
            } else {
                // red - 0
                dp[i][0] = cost[i + 1][0] + Integer.min(dp[i + 1][1], dp[i + 1][2]);
                //blue - 1
                dp[i][1] = cost[i + 1][1] + Integer.min(dp[i + 1][0], dp[i + 1][2]);
                // green - 2
                dp[i][2] = cost[i + 1][2] + Integer.min(dp[i + 1][1], dp[i + 1][0]);
            }
        }

        return Integer.min(dp[0][0], Integer.min(dp[0][1], dp[0][2]));
     }
}
