package ibf.assessment;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//webserver
public class HttpServer {

 
    private int port;
    private String []docRoot;
    private ServerSocket ss;


    public HttpServer(int port, String[] docRoot){
        this.port = port;
        this.docRoot = docRoot;
    }
    public String[] getDocRoot(){
        return this.docRoot;
    }
    
    public void start(){
        this.initializeServer();{ 
        try {
            this.startingServer();
        } catch (IOException e ) {
            System.out.println("socket having issues....");
            System.exit(1);
        }
        return;
        }
    }
     void initializeServer() {
         try{
             this.ss = new ServerSocket(port);
         } catch(IOException){
             System.out.println("port "+port +"having issues..starting");
         }

    private void startingServer() throws IO Exception{
        while(true){
            Socket socket = ss.accept();
        }

    }



    // put inside httpserver)


    
     
    
    

    
    

   
}
