package pipecharacterstream;

import java.io.PipedWriter;

public class PipeWriteThread implements Runnable {

    private PipeCharWriteStream pipeCharWriteStream;
    private PipedWriter pipedWriter;

    public PipeWriteThread(PipeCharWriteStream pipeCharWriteStream, PipedWriter pipedWriter) {
        this.pipeCharWriteStream = pipeCharWriteStream;
        this.pipedWriter = pipedWriter;
    }

    @Override
    public void run() {
        pipeCharWriteStream.writeMethod(pipedWriter);
    }
}
