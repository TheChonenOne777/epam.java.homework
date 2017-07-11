package networking;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable{

    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public Client(Socket s) throws IOException {
        socket = s;
        is = s.getInputStream();
        os = s.getOutputStream();
    }

    @Override
    public void run() {
        try {
            readHeaders();
            writeResponse("Hello World");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client processing finished");
    }

    private void readHeaders() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        System.out.println("Request headers:");
        while(true){
            String s = br.readLine();
            System.out.println(s);
            if(s == null || s.trim().length() == 0) break;
        }
    }

    private void writeResponse(String input) throws IOException {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Server : server" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + input.length() + "\r\n" +
                "Connection: close\r\n\r\n" +
                input;
        os.write(response.getBytes());
        os.flush();
    }
}
