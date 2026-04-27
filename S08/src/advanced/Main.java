package advanced;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int nrElements = 500_000_000;
        int nrThreads = 4;

        long[] array = new long[nrElements];
        for (long i = 0; i < nrElements; i++)
            array[(int)i] = i +1;

        long time = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < nrElements; i++)
            sum += array[i];
        System.out.println("Sequential: s = " + sum + " " + (System.currentTimeMillis() - time));


        time = System.currentTimeMillis();
        sum = 0;
        ParallelSum[] ps = new ParallelSum[nrThreads];
        for (int i =0; i < nrThreads; i++) {
            ps[i] = new ParallelSum((i + 1)*nrElements/nrThreads, i*nrElements/nrThreads, array);
            ps[i].start();
        }

        for (int i = 0; i < nrThreads; i++) {
            ps[i].join();
            sum += ps[i].sum;
        }
        System.out.println("Sequential: s = " + " " + (System.currentTimeMillis() - time));

    }
}
