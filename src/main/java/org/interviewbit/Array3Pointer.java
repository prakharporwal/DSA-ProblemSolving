package org.interviewbit;

public class Array3Pointer {
    //    You are given 3 arrays A, B and C. All 3 of the arrays are sorted.
//    Find i, j, k such that :
//
//    max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
//    Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
//            **abs(x) is absolute value of x and is implemented in the following manner : **
//
//            if (x < 0) return -x;
//      else return x;
//    Example :
//
//    Input :
//    A : [1, 4, 10]
//    B : [2, 15, 20]
//    C : [10, 12]
//
//    Output : 5
//    With 10 from A, 15 from B and 10 from C.
    public static void main(String[] args) {
        int[] A = {1, 3, 4, 10}, B = {10, 15, 20}, C = {5, 15, 23};
        System.out.println(solve(A, B, C));
        System.out.println(solve2(A, B, C));
    }

    /// solution 2
    public static int solve2(final int[] A, final int[] B, final int[] C) {
        int i = 0, j = 0, k = 0;
        int ans=Integer.MAX_VALUE;

        while(i<A.length && j<B.length && k<C.length){
            int mn= Integer.min(A[i],Integer.min(B[j],C[k]));
            int mx= Integer.max(A[i],Integer.max(B[j],C[k]));

            ans = Integer.min(ans, mx-mn);
            if(A[i]<=B[j] && A[i]<=C[k])
                i++;
            else if(B[j]<=C[k] && B[j]<=A[i])
                j++;
            else k++;
        }

        return ans;
    }
    public static int solve(final int[] A, final int[] B, final int[] C) {
        int i = 0, j = 0, k = 0;

        int ans = Integer.MAX_VALUE;
        for (int z = 0; z < A.length; z++) {
            int numB = binarySearchNearest(B, A[z]);
            int numC = binarySearchNearest(C, A[z]);
            ans = Integer.min(ans,Integer.max(Math.abs(numC - numB), Integer.max(Math.abs(numC - A[z]), Math.abs(numB - A[z]))));
        }

        return ans;
    }

    private static int binarySearchNearest(int[] A, int t) {

        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == t)
                return A[mid];
            else if (A[mid] > t)
                r = mid - 1;
            else
                l = mid + 1;
        }
        if (l >= A.length)
            l = A.length - 1;
        if (r < 0)
            r = 0;

        if (Math.abs(t - A[r]) <= Math.abs(A[l] - t))
            return A[r];

        return A[l];
    }
}

