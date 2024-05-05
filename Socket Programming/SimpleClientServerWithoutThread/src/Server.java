import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("SERVER started...");
        Socket socket = serverSocket.accept();
        System.out.println("CLIENT connected...");

        while (true) {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            try {
                Object clientMsg = ois.readObject();
                System.out.println("\nSERVER received: " + (String)clientMsg);

                String serverMsg = (String) clientMsg;
                serverMsg = serverMsg.toUpperCase();

                oos.writeObject(serverMsg);
                System.out.println("SERVER sent: " + serverMsg);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
