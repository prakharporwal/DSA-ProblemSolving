package org.interviewbit;

public class MinimumOperationToMakeAll1 {
    public static void main(String[] args) {
        System.out.println(solve("00010110",3));
    }

    public static int solve(String A, int B){
        int cnt = 0;
        StringBuilder S = new StringBuilder(A);

        for(int i=0;i<S.length()-B;i++){
            if(S.charAt(i)=='0'){
                cnt++;
                for(int j=0;j<B;j++){
                    if(S.charAt(i+j)=='1')
                        S.setCharAt(i+j,'0');
                    else
                        S.setCharAt(i+j,'1');
                }
            }
        }

        for(int i=0;i<S.length();i++){
            if(S.charAt(i) != '1')
                return -1;
        }
        return cnt;
    }
}


