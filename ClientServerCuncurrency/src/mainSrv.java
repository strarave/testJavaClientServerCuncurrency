import Server.RemoteView;

import java.io.IOException;
import java.net.ServerSocket;

public class mainSrv {
    public static void main(String[] args) {
        ServerSocket srv;
        RemoteView rv;
        try{
            srv = new ServerSocket(7007);
            System.out.println("Server waiting on port 7007");
            rv = new RemoteView(srv.accept());
            System.out.println("Connection accepted!");
            rv.startMessaging();
        }catch(IOException x){
            System.err.println(x.getMessage());
        }

    }
}
