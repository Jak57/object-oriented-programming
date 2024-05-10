import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    void startServer() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");
                new ClientHandler(socket);
            }
        } catch (IOException e) {
            closeServer(serverSocket);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void closeServer(ServerSocket serverSocket) {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server started...");
        Server server = new Server(serverSocket);
        server.startServer();
    }
}
