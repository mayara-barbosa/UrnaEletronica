package urnaeletronicaclient;

import com.sun.org.apache.xalan.internal.xsltc.trax.OutputSettings;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Mayara
 */
public class UrnaEletronicaClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket urnaCliente;
        urnaCliente  = new Socket("127.0.0.1", 9999);
        
        int escolha;
        Scanner sc;
        sc = new Scanner(System.in);
        
        System.out.println("Digite 1 para votar:");
        escolha = sc.nextInt();
        
        OutputStream os;
        os = urnaCliente.getOutputStream();
        DataOutputStream dos;
        dos = new DataOutputStream(os);
        
        for(;;){
            dos.writeInt(escolha);
            Thread.sleep(1000);
        }
        
                
        
        
              
    }

    
    
}
