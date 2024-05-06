import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class WriterThread implements Runnable {
    ObjectOutputStream oos;
    Socket socket;
    Thread t;

    WriterThread(ObjectOutputStream oos, Socket socket) {
        this.oos = oos;
        this.socket = socket;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String cMsg = scanner.nextLine();
            if (cMsg.equals("exit"))
                break;

            try {
                oos.writeObject(cMsg);
                System.out.println("CLIENT sent: " + cMsg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
