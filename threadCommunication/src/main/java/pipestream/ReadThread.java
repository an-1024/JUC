package pipestream;

import java.io.PipedInputStream;

public class ReadThread implements Runnable{

    private ReadData readData;
    private PipedInputStream inputStream;


    public ReadThread(ReadData readData, PipedInputStream inputStream) {
        this.readData = readData;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        readData.readMethod(inputStream);
    }
}
