package urnaeletronicaserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mayara
 */
public class UrnaEletronicaServer {

    public static void main(String[] args) throws IOException {
        List<Candidato> votos = new ArrayList<Candidato>();
        ServerSocket urnaServer;
        urnaServer = new ServerSocket(9999);
        
        Candidato c = new Candidato();
        c.setCodigo(0);
        c.setVotos(0);
        votos.add(c);
        Candidato c2 = new Candidato();
        c2.setCodigo(1);
        c2.setVotos(0);
        votos.add(c2);
        Candidato c3 = new Candidato();
        c3.setCodigo(2);
        c3.setVotos(0);
        votos.add(c3);
        Candidato c4 = new Candidato();
        c4.setCodigo(3);
        c4.setVotos(0);
        votos.add(c4);   
        
        
        for(;;){
            Socket cliente;
            cliente = urnaServer.accept();
            new Thread((Runnable) new TratarClientRunnable(cliente)).start();
        }
                
    }
    
}
