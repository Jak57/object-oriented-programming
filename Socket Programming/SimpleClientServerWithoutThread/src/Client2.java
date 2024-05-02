import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String args[]) throws IOException {
        System.out.println("Client started...");
        Socket socket = new Socket("127.0.0.1", 22222); // 127.0.0.1 -> IP address of localhost; 22222 -> Port number of server
        System.out.println("Client connected...");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Scanner sc = new Scanner(System.in); // taking input from console
        System.out.print("Enter: ");
        String message = sc.nextLine(); // taking input as string
        oos.writeObject(message); // sent to server

        try {
            Object fromServer = ois.readObject(); // receiving object from server
            System.out.println("From server: " + (String)fromServer);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}