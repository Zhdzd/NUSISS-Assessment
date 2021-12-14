package ibf.assessment;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        
        ServerSocket server = new ServerSocket(3000);
        Socket socket = server.accept();
       
        HttpServer httpServer = new HttpServer(0, args);

        if (httpServer(3000, "--port")){
            
        }


        
        
    }

    
}
