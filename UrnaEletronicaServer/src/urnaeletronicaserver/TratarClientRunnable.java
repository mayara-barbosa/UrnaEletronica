package urnaeletronicaserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author Mayara
 */
public class TratarClientRunnable implements Runnable{
    private Socket cliente;

    public TratarClientRunnable(Socket cliente) {
        this.cliente = cliente;
    }
    
        @Override
	public void run() {
		InputStream is;
                OutputStream os;
                
            while(cliente.isClosed()== false){
                                  
		try{
			is = cliente.getInputStream();
			DataInputStream dis;
			dis = new DataInputStream(is);
                        os = cliente.getOutputStream();
                        DataOutputStream dos;
                        dos = new DataOutputStream(os);
			int num, num2;
                        num = dis.readInt(); //comando para votar 1
                        num2 = dis.readInt();
                        if (num == 1){
                            num2 = dis.readInt();
                            dos.writeBoolean(true);
                        }
                        
			System.out.println(num2); 
			
		}catch(IOException ex){

			Logger.getLogger(TratarClientRunnable.class.getName());
		}
	   }
    }
}
