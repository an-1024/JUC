package com.anzhi.threadstate.newrunnableterminatedstate;

public class BlockedThreadService {
    synchronized static public void serviceMethod(){
        try{
            System.out.println(Thread.currentThread().getName() + "进入了业务方法!");
            Thread.sleep(100);
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
