import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread implements Runnable {
    Socket socket;
    Thread t;

    ServerThread(Socket socket) {
        this.socket = socket;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                Object cMsg = ois.readObject();

                if (cMsg == null)
                    break;

                System.out.println("\nSERVER received: " + (String) cMsg);

                String sMsg = (String) cMsg;
                sMsg = sMsg.toUpperCase();

                oos.writeObject(sMsg);
                System.out.println("SERVER sent: " + sMsg);
            } catch (ClassNotFoundException | IOException e) {
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

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            new ServerThread(socket);
        }
    }
}