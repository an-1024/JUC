package pipecharacterstream;

import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeReaderWriterDemo {
    public static void main(String[] args) throws Exception {
        PipedWriter pipedWriter = new PipedWriter();
        PipeCharWriteStream pipeCharWriteStream = new PipeCharWriteStream();
        PipeWriteThread writeThread = new PipeWriteThread(pipeCharWriteStream,pipedWriter);
        Thread w_Thread = new Thread(writeThread);

        PipedReader pipedReader = new PipedReader();
        PipeCharReadStream pipeCharReadStream = new PipeCharReadStream();
        PipeReaderThread pipeReaderThread = new PipeReaderThread(pipeCharReadStream, pipedReader);
        Thread r_Thread = new Thread(pipeReaderThread);

        // 管道建立连接
        // pipedReader.connect(pipedWriter);
        pipedWriter.connect(pipedReader);

        w_Thread.start();

        Thread.sleep(2000);

        r_Thread.start();
    }
}
