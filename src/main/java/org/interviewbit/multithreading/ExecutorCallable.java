package org.interviewbit.multithreading;

import java.util.concurrent.Callable;

public class ExecutorCallable implements Callable<Integer> {

    @Override
    public Integer call(){
        return 4;
    }
}
