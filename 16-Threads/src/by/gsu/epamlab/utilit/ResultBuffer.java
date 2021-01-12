package by.gsu.epamlab.utilit;

import by.gsu.epamlab.beans.Result;

import static by.Constants.*;

public class ResultBuffer {
    private Result result;
    private volatile boolean emptyBufferFlag = true;
    private volatile boolean nextResultFlag;

    public ResultBuffer(boolean nextResultFlag) {
        this.nextResultFlag = nextResultFlag;
    }

    public synchronized boolean hasNext() {
        return nextResultFlag || !emptyBufferFlag;
    }

    public synchronized void setResultAndNextFlag(Result result, boolean nextResultFlag) {
        while (!emptyBufferFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(EXCEPTION_WAIT_NEXT_RESULT + e);
            }
        }
        emptyBufferFlag = false;
        this.nextResultFlag = nextResultFlag;
        this.result = result;
        notifyAll();
    }

    public synchronized Result getResult() {
        while (emptyBufferFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(EXCEPTION_GET_NEXT_RESULT + e);
            }
        }
        emptyBufferFlag = true;
        notifyAll();
        return result;
    }
}
