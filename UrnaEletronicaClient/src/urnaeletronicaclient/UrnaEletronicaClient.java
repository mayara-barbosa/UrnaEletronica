package urnaeletronicaclient;

import com.sun.org.apache.xalan.internal.xsltc.trax.OutputSettings;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Mayara
 */
public class UrnaEletronicaClient {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        // conecta socket passando ip e porta
        Socket client;
        client = new Socket("127.0.0.1", 9999);
        int numero,numeroCandidato;
        Scanner sc;
        sc = new Scanner(System.in);
        
        System.out.println("Digite 1 para votar: ");
        numero = sc.nextInt();
        //System.out.println("Numero candidato: ");
        //numeroCandidato = sc.nextInt();
        
        OutputStream os;
        os = client.getOutputStream();
        DataOutputStream dos;
        dos = new DataOutputStream(os);
        for(;;){
			dos.writeInt(numero);                        
			Thread.sleep(1000);
		}
        
                
        
        
              
    }

    
    
}
