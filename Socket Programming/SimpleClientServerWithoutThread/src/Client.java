import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("CLIENT started...");
        Socket clientSocket = new Socket("127.0.0.1", 22222);
        System.out.println("SERVER connected...");

        while (true) {
            System.out.print("\nPlease enter message: ");
            Scanner scanner = new Scanner(System.in);
            String clientMsg = scanner.nextLine();

            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());

            oos.writeObject(clientMsg);
            System.out.println("CLIENT sent: " + clientMsg);

            try {
                Object fromServer = ois.readObject();
                System.out.println("CLIENT received: " + (String) fromServer);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
