package com.anzhi.internalvariable;

public class InternalVariableThreadA extends Thread{

    private InternalVariable internalVariable;

    public InternalVariableThreadA(InternalVariable internalVariable){
        this.internalVariable = internalVariable;
    }

    @Override
    public void run() {
        internalVariable.addI("a");
    }
}
