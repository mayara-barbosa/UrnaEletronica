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
public class TratarClientRunnable {
    private Socket cliente;

    public TratarClientRunnable(Socket cliente) {
        this.cliente = cliente;
    }
    
    public void run(){
        InputStream is;
        OutputStream os;
        try{
            is = cliente.getInputStream();
            DataInputStream dis;
            dis = new DataInputStream(is);
            int num, num2;
            num = dis.readInt();
            System.out.println(num);
            os = cliente.getOutputStream();
            DataOutputStream dos;
            dos = new DataOutputStream(os);
            if(num == 1)
                dos.writeBoolean(true);
            
        }catch(IOException ex){
            Logger.getLogger(TratarClientRunnable.class.getName());
        }
                
    }
}
