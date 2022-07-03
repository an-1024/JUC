package pipecharacterstream;

import java.io.IOException;
import java.io.PipedWriter;

public class PipeCharWriteStream {
    public void writeMethod(PipedWriter out){
        System.out.print("write: ");
        for(int i=0; i<300; i++){
            String outData = "" + (i+1);
            try {
                out.write(outData);
            } catch (IOException e) {
                // doNothing
            }
            System.out.print(outData);
        }
        System.out.println();
        try {
            out.close();
        } catch (IOException e) {
            // doNothing
        }
    }
}
