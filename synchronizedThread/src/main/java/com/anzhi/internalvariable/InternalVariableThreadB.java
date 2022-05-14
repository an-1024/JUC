package com.anzhi.internalvariable;

public class InternalVariableThreadB extends Thread{

    private InternalVariable internalVariable;

    public InternalVariableThreadB(InternalVariable internalVariable){
        this.internalVariable = internalVariable;
    }

    @Override
    public void run() {
        internalVariable.addI("b");
    }
}
