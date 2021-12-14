package ibf.assessment;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException{
        int port = 3000;
        String[] docRoot = new String[]{};

       
       // HTTp start on port 3000

       if (args.length == 2){
        port = Integer.parseInt(args[1]);
       } else if (args[0]== "--docRoot"){
           docRoot = args[1].split(":");
       } else{
        System.out.println("Server listening at port 3000");
       }

    

       HttpServer server = new HttpServer(port, docRoot);
       server.start();
       
       
    }



    
}
