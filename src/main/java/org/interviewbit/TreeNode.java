package org.interviewbit;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}

    public TreeNode(int val){
        this.val = val;
    }
    public static TreeNode makeTree(int[] A){
        return helper(A,0);
    }

    private static TreeNode helper(int[] A, int i){
        if( i >= A.length || A[i]==-1)
            return null;

        TreeNode root = new TreeNode(A[i]);
        root.left = helper(A,2*i + 1);
        root.right = helper(A,2*i + 2);
        return root;
    }
}
