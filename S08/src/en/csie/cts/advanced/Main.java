package en.csie.cts.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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
            ps[i] = new ParallelSum(i*nrElements/nrThreads, (i + 1)*nrElements/nrThreads, array);
            ps[i].start();
        }

        for (int i = 0; i < nrThreads; i++) {
            ps[i].join();
            sum += ps[i].sum;
        }
        System.out.println("Parallel thread array: s = " + sum + " " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        sum = 0;

        ExecutorService threadpool = Executors.newFixedThreadPool(nrThreads);
        ps = new ParallelSum[nrThreads];
        for (int i =0; i < nrThreads; i++) {
            ps[i] = new ParallelSum(i*nrElements/nrThreads, (i + 1)*nrElements/nrThreads, array);
            threadpool.execute(ps[i]);
        }

        threadpool.shutdown();
        threadpool.awaitTermination(5, TimeUnit.SECONDS);
        for (int i = 0; i < nrThreads; i++) {
            sum += ps[i].sum;
        }

        System.out.println("Threadpool runnable: s = " + sum + " " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        sum = 0;


        threadpool = Executors.newFixedThreadPool(nrThreads);
        CallableSum[] cs = new CallableSum[nrThreads];
        List<Future<Long>> fl = new ArrayList<>();
        for (int i =0; i < nrThreads; i++) {
            cs[i] = new CallableSum(i*nrElements/nrThreads, (i + 1)*nrElements/nrThreads, array);
            fl.add(threadpool.submit(cs[i]));
        }

        threadpool.shutdown();
//        threadpool.awaitTermination(5, TimeUnit.SECONDS);
        for(Future<Long> f : fl){
            try {
                sum += f.get();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Threadpool callable: s = " + sum + " " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        sum = 0;

    }
}
