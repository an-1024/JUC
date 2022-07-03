package pipestream;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
    public void readMethod(PipedInputStream pipedInputStream){
        System.out.println("read   ;");
        byte[] byteArray = new byte[20];
        try {
            int readLength = pipedInputStream.read(byteArray);
            while(readLength != -1){
                String newData = new String(byteArray, 0, readLength);
                System.out.print("read : " + newData + " ");
                readLength = pipedInputStream.read(byteArray);
            }
            System.out.println();
            pipedInputStream.close();
        } catch (IOException e) {
            // doNothing
        }
    }
}
