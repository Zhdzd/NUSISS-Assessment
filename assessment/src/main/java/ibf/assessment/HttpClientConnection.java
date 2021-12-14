package ibf.assessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpClientConnection implements Runnable{
    private final Socket socket;
    private BufferedReader reader;
    private HttpWriter writer;
    
    
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



private String[] fromBrowser() throws IOException{
    String requesting = reader.readLine();
    String[] requestingArgs =requesting.split(" ");
    return requestingArgs;
}

private void receiveRequest(String[] fromBrowser) {

    String method = requestingArgs[0];
    String url = requestingArgs[1];

    if 
}

private void initializeStreams() {

    try {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new HttpWriter(socket.getInputStream());
    } catch(IOException e){
        e.printStackTrace();
        System.out.println("Error when initializing input/output streams");
    }
    return;
}
    
  
}
