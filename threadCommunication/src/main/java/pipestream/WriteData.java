package pipestream;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {
    public void writeMethod(PipedOutputStream out){
        System.out.println("write : ");
        for(int i=0; i<300; i++){
            String outData = "" + (i+1);
            try {
                out.write(outData.getBytes());
                System.out.print(outData);
            } catch (IOException e) {
                // doNothing
            }
        }
        System.out.println();
        try {
            out.close();
        } catch (IOException e) {
            // doNothing
        }
    }
}
