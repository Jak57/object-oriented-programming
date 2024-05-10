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

    public ClientHandler(Socket socket) throws IOException, ClassNotFoundException {
        this.socket = socket;
        this.ois = new ObjectInputStream(socket.getInputStream());
        this.oos = new ObjectOutputStream(socket.getOutputStream());
        t = new Thread(this);
        Object name = null;
        name = ois.readObject();
        this.username = (String)name;
        String messageToSend = "SERVER: " + (String)username + " joined the chat!";
        broadcastMessageToAll(messageToSend);
        clientHandlers.add(this);
        t.start();
    }

    void broadcastMessageToAll(String messageToSend) throws IOException {
        for (ClientHandler clientHandler: clientHandlers) {
            String tempName = clientHandler.username;
            if (!tempName.equals(username))
                clientHandler.oos.writeObject(messageToSend);
        }
    }

    void handleAllException(Socket socket, ObjectInputStream ois, ObjectOutputStream oos) {
        clientHandlers.remove(this);
        String messageToSend = username + " left the chat!";
        try {
            broadcastMessageToAll(messageToSend);
            if (ois != null) ois.close();
            if (oos != null) oos.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object messageFromServerObject = null;
                messageFromServerObject = ois.readObject();
                String messageFromServer = (String) messageFromServerObject;
                System.out.println("\nSERVER received: " + messageFromServer);
                String messageToSend = username + ": " + messageFromServer;
                broadcastMessageToAll(messageToSend);
            }
        } catch (IOException | ClassNotFoundException e) {
            handleAllException(socket, ois, oos);
        }
    }
}
