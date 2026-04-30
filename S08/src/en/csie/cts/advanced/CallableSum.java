package en.csie.cts.advanced;

import java.util.concurrent.Callable;

public class CallableSum implements Callable<Long> {
    private long[] array;
    private long startIndex;
    private long endIndex;

    public CallableSum(long startIndex, long endIndex, long[] array) {
        this.endIndex = endIndex;
        this.startIndex = startIndex;
        this.array = array;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (long i = startIndex; i < endIndex; i++)
            sum += array[(int)i];
        return sum;
    }
}
