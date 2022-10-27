import java.io.*;
import java.net.*;


class TCPClient {
    public static void main(String argv[]) throws Exception {
        String fromServer;
        Socket clientSocket = new Socket("localhost", 6789);
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        fromServer = inFromServer.readLine();

        System.out.println("FROM SERVER: " + fromServer);

        clientSocket.close();

    }
}