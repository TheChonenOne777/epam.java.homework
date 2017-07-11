package networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 5555;
    private ServerSocket ss;

    public Server(){
        try {
            ss = new ServerSocket(PORT);
            InetAddress ia = InetAddress.getLocalHost();
            System.out.printf("Listening on %s:%d\n", ia.getHostAddress(), PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitClient() throws IOException {
        Socket socket = ss.accept();
        System.out.println("Client accepted");
        new Thread(new Client(socket)).start();
    }

    public static void main(String[] args) throws IOException {
        Server srv = new Server();
        while(true){
            srv.waitClient();
        }
    }
}
