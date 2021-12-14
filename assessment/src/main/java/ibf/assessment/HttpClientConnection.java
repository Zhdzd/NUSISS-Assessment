package ibf.assessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.file.Paths;

public class HttpClientConnection implements Runnable{
    private final Socket socket;
    private BufferedReader reader;
    private HttpWriter writer;
    private Object write;
 
    
    
public HttpClientConnection(Socket socket){
    this.socket = socket;
}

public void run(){
    initializeStreams();
    try{
        receiveRequest(fromBrowser());
        socket.close();
    } catch (IOException e){
        e.printStackTrace();
    }
}
private void initializeStreams() {

    try {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new HttpWriter(socket.getOutputStream());
    } catch(IOException e){
        e.printStackTrace();
        System.out.println("Error when initializing input/output streams");
    }
    return;
}

private String[] fromBrowser() throws IOException{
    String requesting = reader.readLine();
    String[] requestingArgs =requesting.split(" ");
    return requestingArgs;
}

private void receiveRequest(String[] fromBrowser) {

    String method = fromBrowser[0];
    String link = fromBrowser[1];

    if (!method.equals("Get")){
        this.writer.writeString("405 method");
        return;
    }
    if(!Paths.get(link).toFile().exists()){
        this.writer.writeString("404 not found\n");
        this.writer.writeString(link + "not found");
        return;
    } else {
        String fileDir = file.Opt.get();
        if(isPNG(link)){
            this.writePNG();
        }
        this.writePage(fileDir);
        return;
    }
}


private void write405(String method){
    String title = "HTTP/1.1 405 Method not Allowed";
    String message = method + "not supported";
    try {
        writer.writeString(title);
        writer.writeString();
        writer.writeString(message);
        writer.close();
    } catch (Exception e){
        System.out.println("cant reach to browser");
    }

    }
    private void writePage(String filedir){
        String header = "Http/1.1 200 ok";
        String content= new list;
        try{
            writer.writeString(header);
            writer.writeString();
            for (String html: contents){
                writer.writeString(html);
            }
        }
    
    
    private void writePNG(String fileLoc){
        String header = "Http/1.1 200 ok";
        String contentType = "image/png";
        try{
            byte[] imageBytes = fileDir;
            writer.writeString(header);
            writer.writeString(contentType);
            writer.writeString();
            writer.writeBytes();
            writer.close();

        }
    }

    
  
}
