package org.interviewbit.multithreading;

public class Print1to100 implements Runnable{
    int val;

    Print1to100(int val){
        this.val = val;
    }
    @Override
    public void run(){
        System.out.println(this.val +" "+ Thread.currentThread().getName());
    }
}
