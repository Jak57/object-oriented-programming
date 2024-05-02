
class NewThread  implements  Runnable {
    Thread t; // global thread
    int threadNo;
    NewThread(int threadNo) {
        t = new Thread(this, "Runnable Thread 1");
        this.threadNo = threadNo;
        t.start(); // after calling start() method, run() method will be called automatically
    }

    @Override
    public void run() {
        System.out.println(threadNo + " -> Started child thread.");
        for (int i = 5; i > 0; i--) {
            System.out.println(threadNo + " -> Child thread: " + i);
            try {
                Thread.sleep(500); // 500 ms sleeping periods
            } catch (InterruptedException e) {
                System.out.println(threadNo + " -> Child thread interrupted");
            }
        }
        System.out.println(threadNo + " -> Exiting child thread.");
    }
}

public class RunnableThread {
    public static void main(String[] args) {
        System.out.println("Main thread started...");

        NewThread ob1 = new NewThread(1);
        NewThread ob2 = new NewThread(2);

        System.out.println("Thread 1 is alive: " + ob1.t.isAlive());
        System.out.println("Thread 2 is alive: " + ob2.t.isAlive());

        try {
            ob1.t.join(); // join() is used so that main thread keeps alive
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            ob2.t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread 1 is alive: " + ob1.t.isAlive());
        System.out.println("Thread 2 is alive: " + ob2.t.isAlive());

        System.out.println("Main thread exited...");
    }
}
