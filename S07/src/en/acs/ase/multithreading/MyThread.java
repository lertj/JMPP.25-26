package en.acs.ase.multithreading;

public class MyThread extends Thread{
    static int x = 0;
    static int y = 0;
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            x++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            y++;
            System.out.println("x = " + x + " y = " + y);
        }
    }
}
