package en.csie.cts.multithread;

import java.util.Random;

public class MyThread extends Thread{
    // run - define the behaviour of what we want to do
    // start - put it on a separate thread

    private static int a = 0;
    private static int b = 0;
    private static Object lock = new Object();

    @Override
    public void run() {
        super.run();
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
