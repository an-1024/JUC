package com.anzhi.visibility;

public class VolatileVisibilityDemo {
    private boolean isContinuePrintPrint = true;

    public boolean isContinuePrintPrint(boolean isContinuePrintPrint){
        return isContinuePrintPrint;
    }

    public void printStringMethodMethod(){
        try{
            while (isContinuePrintPrint) {
                System.out.println("run printStringMethodMethod threadName= " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch (Exception e){
            // doNothing
        }
    }
}
