package en.csie.cts.multithread;

import java.util.Random;

public class MyRunnable implements Runnable{
    private static int a = 0;
    private static int b = 0;
    private static Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            add();
    }

    public void add() {
        synchronized (lock) {
            a++;
            try {
                Thread.sleep(new Random().nextInt(3000)); // if you give 1 param, it s the upper limit; if 2 param, both lower and upper limits
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            b++;
            System.out.println("a = " + a + " b = " + b);
        }
    }
}
