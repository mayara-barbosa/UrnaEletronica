package urnaeletronicaserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mayara
 */
public class UrnaEletronicaServer {

    public static void main(String[] args) throws IOException {
        ServerSocket urnaServer;
        urnaServer = new ServerSocket(9999);
        
        for(;;){
            Socket cliente;
            cliente = urnaServer.accept();
            new Thread((Runnable) new TratarClientRunnable(cliente)).start();
        }
                
    }
    
}
