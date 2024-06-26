// v1

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws IOException {
        System.out.println("Client started...");
        Socket socket = new Socket("127.0.0.1", 22222); // 127.0.0.1 -> IP address of localhost; 22222 -> Port number of server
        System.out.println("Client connected...");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        while (true) {
            Scanner sc = new Scanner(System.in); // taking input from console
            System.out.print("Enter: ");
            String message = sc.nextLine(); // taking input as string

            if (message.equals("exit"))
                break;

            oos.writeObject(message); // sent to server

            try {
                Object fromServer = ois.readObject(); // receiving object from server
                System.out.println("From server: " + (String) fromServer);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        socket.close();
    }
}

// v2

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 22222);
        System.out.println("Client connected...");

        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());

        while (true) {
            System.out.print("\nPlease, enter your message: ");
            Scanner scanner = new Scanner(System.in);
            String cMsg = scanner.nextLine();

            if (cMsg.equals("exit"))
                break;
            System.out.println("CLIENT sent: " + cMsg);
            oos.writeObject(cMsg);

            try {
                Object sMsg = ois.readObject();
                System.out.println("CLIENT received: " + (String) sMsg);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        clientSocket.close();
    }
}
