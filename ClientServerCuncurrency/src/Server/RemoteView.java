package Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class RemoteView {
    private Socket socket;

    public RemoteView(Socket connectionSocket){
        this.socket = connectionSocket;
    }

    public void startMessaging() throws IOException{
        Scanner input = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());

        Thread listen = new Thread(() -> {
            while(true){
                System.out.println(input.nextLine());
            }
        }), send = new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out.println("Wella");
            }
        });

        listen.start();
        send.start();
    }
}
