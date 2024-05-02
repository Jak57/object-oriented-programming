public class MainThread {
    public static void main(String args[]) {
        Thread t = Thread.currentThread(); // one thread will be present always
        System.out.println("Current thread: " + t);

        t.setName("My Thread");
        System.out.println("After name change: " + t);

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(500); // 500 ms sleeping periods
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
    }
}
