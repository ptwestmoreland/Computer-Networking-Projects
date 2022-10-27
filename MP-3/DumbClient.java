import java.io.*;
import java.net.*;


class DumbClient {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = null;
        BufferedReader inFromServer = null;

        try {
            clientSocket = new Socket("localhost", 6789);
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (UnknownHostException e) {

        } catch (IOException e) {

        }

        while (true) {
                System.out.print((char)(inFromServer.read()));
        }
    }
}