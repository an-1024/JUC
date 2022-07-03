package pipebytestream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class WriteReadThreadDemo {
    public static void main(String[] args) {
        ReadData readData = new ReadData();
        WriteData writeData = new WriteData();

        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        try {
            pipedInputStream.connect(pipedOutputStream);
            //pipedOutputStream.connect(pipedInputStream);

            ReadThread readThread = new ReadThread(readData, pipedInputStream);
            Thread r_Thread = new Thread(readThread);
            r_Thread.start();

            WriteThread writeThread = new WriteThread(writeData, pipedOutputStream);
            Thread w_Thread = new Thread(writeThread);
            w_Thread.start();


        } catch (IOException e) {
            // doNothing
        }
    }
}
