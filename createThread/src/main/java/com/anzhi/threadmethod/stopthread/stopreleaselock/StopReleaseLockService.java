package com.anzhi.threadmethod.stopthread.stopreleaselock;

public class StopReleaseLockService {
    private String username = "a";
    private String password = "aa";

    synchronized public String getUsername(){
        return username;
    }

    synchronized public String getPassword(){
        return password;
    }

    synchronized public void printString(String username, String password){
        try{
            this.username = username;
            Thread.sleep(100000000);
            this.password = password;
        }catch (InterruptedException e){

        }
    }
}
