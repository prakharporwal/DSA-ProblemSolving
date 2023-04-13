package org.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(solve("   the sky is    Pinkkk"));
    }

    public static String solve(String A){
        List<String> words = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == ' ') {
                if(curr.length()>0) {
                    words.add(curr.toString());
                    // clear current word
                    curr.setLength(0);
                }
                continue;
            }
            curr.append(A.charAt(i));
        }
        if(curr.length()>0) {
            words.add(curr.toString());
            // clear current word
            curr.setLength(0);
        }

        StringBuilder finalOut = new StringBuilder();

        for(int i=words.size()-1;i>=0;i--){
            finalOut.append(words.get(i));
            if(i!=0)
                finalOut.append(" ");
        }

        return finalOut.toString();
    }
}
