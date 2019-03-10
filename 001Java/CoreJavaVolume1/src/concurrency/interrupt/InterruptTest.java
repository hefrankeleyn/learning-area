package concurrency.interrupt;

/**
 * InterruptTest
 */
public class InterruptTest {

    private static int i =0;
    public static void main(String[] args) {
        beginNewThread();
    }

    private static void beginNewThread() {
        Runnable r = () -> {
            try {
                // int i = 1;
                while (!Thread.currentThread().isInterrupted() && i < 10) {
                    System.out.println("Thread interrupt test "+i+"...");
                    i ++;
                    if (i==3){
                        Thread.sleep(1000);
                        System.out.println("sleep begin..");
                    }
                }
            } catch (InterruptedException e) {

            }
        };

        Thread t = new Thread(r);
        t.start();
        System.out.println(t.getState());
        // while (i < 10){
        // }
    }


}