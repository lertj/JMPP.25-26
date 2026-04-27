package advanced;

public class ParallelSum extends Thread{
    private long[] array;
    private long startIndex;
    private long endIndex;
    public long sum = 0;

    public ParallelSum(long endIndex, long startIndex, long[] array) {
        this.endIndex = endIndex;
        this.startIndex = startIndex;
        this.array = array;
    }

    @Override
    public void run() {
        super.run();
        for (long i = startIndex; i < endIndex; i++)
            sum += array[(int)i];
    }
}
