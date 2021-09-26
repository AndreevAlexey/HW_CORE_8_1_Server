import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        int port = 28989;
        System.out.println("Serever started "+System.currentTimeMillis());
        while(true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
            ) {
                System.out.println("New connection port = " + clientSocket.getPort());
                final String message = in.readLine();
                System.out.println(message);
                out.println(String.format("Hi %s, your port is %d", message, clientSocket.getPort()));
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }
    }
}
