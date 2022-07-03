package pipecharacterstream;

import java.io.PipedReader;

public class PipeReaderThread implements Runnable {

    private PipeCharReadStream pipeCharReadStream;
    private PipedReader pipedReader;

    public PipeReaderThread(PipeCharReadStream pipeCharReadStream, PipedReader pipedReader) {
        this.pipeCharReadStream = pipeCharReadStream;
        this.pipedReader = pipedReader;
    }

    @Override
    public void run() {
        pipeCharReadStream.readMethod(pipedReader);
    }
}
