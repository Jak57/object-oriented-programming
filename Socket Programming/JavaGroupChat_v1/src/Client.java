import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

class ReaderThread implements Runnable {
    Thread t;
    ObjectInputStream ois;
    String username;

    ReaderThread(ObjectInputStream ois, String username) {
        this.ois = ois;
        t = new Thread(this);
        this.username = username;
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            Object incomingMessage = null;
            try {
                incomingMessage = ois.readObject();
                System.out.println((String)incomingMessage);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class WriterThread implements Runnable {
    ObjectOutputStream oos;
    Thread t;
    String username;
    WriterThread(ObjectOutputStream oos, String username) {
        this.oos = oos;
        t = new Thread(this);
        this.username = username;
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String messageToSend = scanner.nextLine();
            try {
                oos.writeObject(messageToSend);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Client {
    Socket socket;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    String username;

    public Client(Socket socket, String username) throws IOException {
        this.socket = socket;
        this.oos = new ObjectOutputStream(socket.getOutputStream());
        this.ois = new ObjectInputStream(socket.getInputStream());
        this.username = username;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket clientSocket = new Socket("localhost", 22222);
        System.out.println("Client connected...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter your username: ");
        String username = scanner.nextLine();
        Client client = new Client(clientSocket, username);
        client.oos.writeObject(username);
        new WriterThread(client.oos, username);
        new ReaderThread(client.ois, username);
    }
}
