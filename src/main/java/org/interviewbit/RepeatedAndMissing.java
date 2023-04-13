package org.interviewbit;

public class RepeatedAndMissing {
    public static void main(String[] args) {
        int[] A = {4,1,3,2,5,2};
        int[] x= solve(A);
        System.out.println(x);
    }

    public static int[] solve(final int[] A){

        int squaresum = 0;
        int sum = 0;
        int sumArr = 0;
        int squaresumArr = 0;

        for(int i=0;i<A.length;i++){
            squaresum += (i+1)*(i+1);
            squaresumArr += A[i]*A[i];
            sum += i+1;
            sumArr += A[i];
        }

        int abdiff = sumArr-sum;
        int ab = (squaresumArr - squaresum)/abdiff;

        int a = (ab + abdiff)/2;
        int b = (ab - abdiff)/2;

        return new int[]{a,b};
    }
}
