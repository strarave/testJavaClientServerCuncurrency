package Client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class BaseClient {
    private Socket connectionSocket;

    public BaseClient(Socket connectionSocket){
        this.connectionSocket = connectionSocket;
    }

    public void startMessaging() throws IOException {
        System.out.println("Client up, write messages one per line:");
        Scanner input = new Scanner(connectionSocket.getInputStream()), offlineInput = new Scanner(System.in);
        PrintStream output = new PrintStream(connectionSocket.getOutputStream());

        Thread listen = new Thread(() -> {
            while(true){
                System.out.println("message from server: " + input.nextLine());
            }
        }), send = new Thread(() -> {
            while(true){
                output.println(offlineInput.nextLine());
            }
        });

        listen.start();
        send.start();

    }
}
