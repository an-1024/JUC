package pipecharacterstream;

import java.io.IOException;
import java.io.PipedReader;

public class PipeCharReadStream {
    public void readMethod(PipedReader input){
        System.out.print("read: ");
        char[] byteArray = new char[20];
        try {
            int readLength =  input.read(byteArray);
            while(readLength != -1){
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
        } catch (IOException e) {
            // doNothing
        }finally {
            try {
                input.close();
            } catch (IOException e) {
                // doNothing
            }
        }
    }
}
