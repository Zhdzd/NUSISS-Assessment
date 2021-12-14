package ibf.assessment;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;


//webserver
public class HttpServer {

 
    private int port;
    private String []docRoot;
    private ServerSocket ss;
    private ExecutorService threadPool;


    public HttpServer(int port, String[] docRoot){
        this.port = port;
        this.docRoot = docRoot;
    }
    public String[] getDocRoot(){
        return this.docRoot;
    }
    
    public void start(){
        
        for (int i =0;i<docRoot.length;i++ ){
            Path path = Paths.get(docRoot[i]);
            if (!Files.isDirectory(path)){
                System.exit(1);
            }
            if(!Files.isReadable(path)){
                System.exit(1);
            }
        }

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

    private void startingServer() throws IOException{
        while(true){
            Socket socket = ss.accept();
            threadPool.submit(new HttpClientConnection(socket));
        }
     void initializeServer() {
         try{
             this.ss = new ServerSocket(port);
         } catch(IOException e){
             System.out.println("port "+port +"having issues..starting");
         }



    } 
}
