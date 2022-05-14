package com.anzhi.daemonthread;

public class DaemonThreadMethodA extends Thread{
    private int i=0;

    @Override
    public void run() {
        try{
            while (true){
                i++;
                System.out.println("DaemonThreadMethodA i= " + (i));
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){

        }
    }
}
