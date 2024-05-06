// v1

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


// v2

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

                String sMsg = (String) cMsg;

                System.out.println("\nSERVER received: " + sMsg);
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
