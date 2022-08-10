package com.anzhi.callablethread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadDemoTest {
    public static void main(String[] args) {
        CallableThreadDemo callableThreadDemo = new CallableThreadDemo();
        FutureTask<String> task = new FutureTask<>(callableThreadDemo);
        task.run();
        try {
            String result = (String) task.get();
            System.out.println("start---------------" + result);
        } catch (InterruptedException e) {
            // doNothing
        } catch (ExecutionException e) {
            // doNothing
        }
    }
}
