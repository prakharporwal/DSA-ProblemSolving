package org.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuySellStock2 {
    public static void main(String[] args) {
        // ex : 7,1,5,8,9,2,10
        // -> 1,10 = 9
        // -> 2 9 -> 7 = 16
        // bought sell first then buy =>
        // for a index max to its left is req
        // then that section is blocked and move to next days
        // for profit and at most 2 section can be made
        //
        List<Integer> A = Arrays.asList(7,1,5,8,9,2,10);
        int[][] dp = {
                {-1,-1},
                {-1,-1},
                {-1,-1},
                {-1,-1},
                {-1,-1},
                {-1,-1},
                {-1,-1},
        };

        int val = calculate(A,0,1,2,dp);
        System.out.println(val);
    }

    private static int calculate(List<Integer> A,int i,int b,int cnt, int[][] dp){
        if(i>=A.size() || cnt==0)
            return 0;

        if(dp[i][b]!=-1)
            return dp[i][b];

        if(b==1)
            return dp[i][b] =Integer.max(calculate(A,i+1,b^1,cnt-1,dp) - A.get(i),calculate(A,i+1,b,cnt,dp)) ;

        dp[i][b^1] = Integer.max(calculate(A,i+1,b^1,cnt,dp) + A.get(i), calculate(A,i+1,b,cnt,dp)) ;
        return dp[i][b^1];
    }
}

