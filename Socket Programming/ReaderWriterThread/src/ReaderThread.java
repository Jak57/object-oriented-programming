import java.io.IOException;
import java.io.ObjectInputStream;

public class ReaderThread implements Runnable {
    ObjectInputStream ois;
    Thread t;

    ReaderThread(ObjectInputStream ois) {
        this.ois = ois;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object sMsg = ois.readObject();
                System.out.println("CLIENT received: " + (String) sMsg);
            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
