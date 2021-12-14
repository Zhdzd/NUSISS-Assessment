package ibf.assessment;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        int port = 3000;
        String[] docRoot = new String[]{};

        ServerSocket server = new ServerSocket(3000);
        Socket socket = server.accept();
       
       // HttpServer httpServer = new HttpServer(0, args);

       if (args.length == 2){
        port = Integer.parseInt(args[1]);
       } else if (args[0]== "--docRoot"){
           docRoot = args[1].split(":");
       } else{
        System.out.println("Server listening at port 3000");
       }



       
      
        
        
    }



    
}
