package urnaeletronicaclient;

import com.sun.org.apache.xalan.internal.xsltc.trax.OutputSettings;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        
        do {
                System.out.println ("\n--- Menu --- ");
                System.out.println ("\n1 - Votar");
                System.out.println ("2 - Listar");
                System.out.println ("3 - Encerrar votação");

                System.out.print ("\nOpção: ");
            int opcao = sc.nextInt();
                
                OutputStream osO;
                osO = client.getOutputStream();
                DataOutputStream dosO;
                dosO = new DataOutputStream (osO);
                dosO.writeInt(opcao);                      

                switch (opcao) {
                    case 1:                    
                        System.out.print ("\nCódigo do candidato: ");
                        numeroCandidato = sc.nextInt();

                        OutputStream os;
                        os = client.getOutputStream();
                        DataOutputStream dos;
                        dos = new DataOutputStream (os);
                        dos.writeInt(numeroCandidato);        
                        // Fim envio do codigo do candidato para o servidor        

                        boolean resultado;
                        InputStream is = client.getInputStream();
                        DataInputStream dis;
                        dis = new DataInputStream(is);
                        resultado = dis.readBoolean();

                        if (resultado) {
                            System.out.print("Voto cadastrado.");
                        }
                        else {
                            System.out.print("Candidato não encontrado");
                        }

                        break;

                    case 2:
                        break;
                        
                    case 3:

                        
                        System.out.println("\nVotação encerrada.");
                        break;
                }


            } while (votacao == true);
       
        
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
