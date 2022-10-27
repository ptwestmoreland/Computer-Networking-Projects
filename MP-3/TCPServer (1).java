import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;


public class TCPServer {
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    public static void main(String args[]) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(Integer.parseInt(args[1]));
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Input message for client: ");
        String inputSentence = keyboard.nextLine();
        System.out.print("Input number of times for message to be sent to client: ");
        int N = keyboard.nextInt();
        ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(args[0]));

        while(true) {
            if (clients.size() < Integer.parseInt(args[1])) {
                Socket connectionSocket = welcomeSocket.accept();
                ClientHandler clientThread = new ClientHandler(connectionSocket, inputSentence, N);
                clients.add(clientThread);
                if (clients.size() == 1) {
                    System.out.println("1 thread");
                } else {
                    System.out.println(clients.size() + " threads");
                }

                pool.execute(clientThread);
            } else {
                break;
            }
        }
        System.out.println("No more clients can connect");

    }
}