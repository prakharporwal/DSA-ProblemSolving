package org.interviewbit;

public class LongestIncreasingSubsequnce {
    public static void main(String[] args) {
        int[] A = {10,5,6,1,423,2,3,324,34,};
        System.out.println(lis(A));
    }

    public static int lis(int[] A){
        int n = A.length;
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(A[j]<A[i]){
                    dp[i] = Integer.max(dp[i],dp[j]+1);
                }
            }
        }

        int mx=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++)
            mx = Integer.max(mx,dp[i]);

        return mx+1;
    }
}
