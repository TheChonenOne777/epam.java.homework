package networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Networking {

    public static void main(String[] args) {
        try {
            useSocket("horstmann.com", 80);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void useSocket(String host, int port) throws IOException {
        try (Socket socket = new Socket(host, port);
             PrintWriter pw = new PrintWriter(socket.getOutputStream());
             InputStream is = socket.getInputStream()) {

            pw.println("GET / HTTP/1.1");
            pw.println("HOST: " + host);
            pw.println();
            pw.flush();

            printFromInputStream(is);
        }
    }

    private static void printFromInputStream(InputStream is) {
        Scanner sc = new Scanner(is);
        while (sc.hasNext()){
            System.out.println(sc.nextLine());
        }
    }

    public static void useUrlConnection(String urlString) throws IOException {
        URL url = new URL("http://" + urlString);
        URLConnection connection = url.openConnection();
        try(InputStream is = connection.getInputStream()){
            printFromInputStream(is);
        }
    }

}
