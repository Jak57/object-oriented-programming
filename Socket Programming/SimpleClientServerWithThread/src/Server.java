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

            // start new server thread
            new ServerThread(socket);
        }
    }
}

class ServerThread implements Runnable {
    Socket clientSocket;
    Thread t;

    ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

            while (true) {
                Object cMsg = ois.readObject(); // reading what client has sent

                if (cMsg == null)
                    break;

                System.out.println("From client: " + (String) cMsg); // type casting Object to String
                String serverMsg = (String) cMsg;
                serverMsg = serverMsg.toUpperCase(); // uppercasing message in server side which is sent by client
                oos.writeObject(serverMsg); // sending message to client
            }

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        try {
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
