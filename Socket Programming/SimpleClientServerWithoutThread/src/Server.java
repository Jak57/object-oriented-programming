import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        // Creating object of server socket.
        // Exception can occur -> socket may be off / occupied
        ServerSocket serverSocket = new ServerSocket(22222); // 22222 -> port number
        System.out.println("Server started...");

        while (true) { // server will do the below tasks continuously

            Socket socket = serverSocket.accept(); // dedicated socket is provided to each client
            System.out.println("Client connected...");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            try {
                Object cMsg = ois.readObject(); // reading what client has sent
                System.out.println("From client: " + (String) cMsg); // type casting Object to String

                String serverMsg = (String) cMsg;
                serverMsg = serverMsg.toUpperCase(); // uppercasing message in server side which is sent by client

                oos.writeObject(serverMsg); // sending message to client

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
