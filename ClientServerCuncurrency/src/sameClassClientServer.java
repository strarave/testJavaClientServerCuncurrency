import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class sameClassClientServer {

    public static void main(String[] args) {
        Thread srv = new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(7007);
                System.err.println("Server up, port 7007");
                serverSocket.accept();
                System.err.println("Connection accepted, closing");
            }catch(IOException x){
                x.printStackTrace();
            }
        });

        Thread cli = new Thread(() -> {
            try {
                System.out.println("Client up, connecting...");
                Socket client = new Socket("127.0.0.1", 7007);
                System.out.println("Connected. closing");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        srv.start();
        cli.start();

    }
}
