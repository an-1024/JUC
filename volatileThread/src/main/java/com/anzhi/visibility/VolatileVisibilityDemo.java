package com.anzhi.visibility;

import lombok.Data;

@Data
public class VolatileVisibilityDemo implements Runnable{
    private volatile boolean isContinuePrintPrint = true;

    public void printStringMethodMethod(){
        try{
            System.out.println("start run printStringMethodMethod isContinuePrintPrint = " + isContinuePrintPrint);
            while (Boolean.TRUE.equals(isContinuePrintPrint)) {
                // doSomthing
            }
            System.out.println("printStringMethodMethod stop isContinuePrintPrint = " + isContinuePrintPrint);
        }catch (Exception e){
            // doNothing
        }
    }

    public void run() {
        printStringMethodMethod();
    }
}
