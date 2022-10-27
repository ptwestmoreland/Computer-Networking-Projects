import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;


public class ClientHandler implements Runnable{
    private Socket client;
    private String inputSentence;
    private int N;

    public ClientHandler(Socket clientSocket, String inputSentence, int N) {
        this.inputSentence = inputSentence;
        this.N = N;
        this.client = clientSocket;
    }

    
    public void run() {
        try {
            DataOutputStream outToClient = new DataOutputStream(client.getOutputStream());
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < inputSentence.length(); j++) {
                    outToClient.write(inputSentence.charAt(j));
                }
                outToClient.write(' ');
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < inputSentence.length(); j++) {
                outToClient.write(inputSentence.charAt(j));
            }
            outToClient.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
