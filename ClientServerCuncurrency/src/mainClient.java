import Client.BaseClient;

import java.io.IOException;
import java.net.Socket;

public class mainClient {
    public static void main(String[] args) {
        try {
            BaseClient bc = new BaseClient(new Socket("127.0.0.1", 7007));
            bc.startMessaging();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
