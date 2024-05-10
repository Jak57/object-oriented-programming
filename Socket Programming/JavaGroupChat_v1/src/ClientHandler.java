import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    Socket socket;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    String username;
    Thread t;
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.ois = new ObjectInputStream(socket.getInputStream());
        this.oos = new ObjectOutputStream(socket.getOutputStream());
        t = new Thread(this);
        Object name = null;
        try {
            name = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.username = (String)name;
        String messageToSend = "SERVER: " + (String)username + " joined the chat!";
        for (ClientHandler clientHandler: clientHandlers) {
            String tempName = clientHandler.username;
            if (!tempName.equals(username))
                clientHandler.oos.writeObject(messageToSend);
        }
        clientHandlers.add(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            Object messageFromServerObject = null;
            try {
                messageFromServerObject = ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            String messageFromServer = (String) messageFromServerObject;
            System.out.println("\nSERVER received: " + messageFromServer);
            try {
                for (ClientHandler clientHandler: clientHandlers) {
                    String tempName = clientHandler.username;
                    if (!tempName.equals(username))
                        clientHandler.oos.writeObject(username + ": " + messageFromServer);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
