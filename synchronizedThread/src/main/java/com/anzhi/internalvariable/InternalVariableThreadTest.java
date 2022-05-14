package com.anzhi.internalvariable;


public class InternalVariableThreadTest {

    public static void main(String[] args) {

        InternalVariable internalVariable = new InternalVariable();

        InternalVariableThreadA threadA = new InternalVariableThreadA(internalVariable);
        threadA.setName("threadA");
        threadA.start();

        InternalVariableThreadB threadB = new InternalVariableThreadB(internalVariable);
        threadB.setName("threadB");
        threadB.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
