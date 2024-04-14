import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException{
        
        //creating a socket to connect client from server
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();

        //reading data from socket sent by client 
        DataInputStream is = new DataInputStream(s.getInputStream());
        while(true)
        {
            System.out.println(is.readUTF());
            DataOutputStream os = new DataOutputStream(s.getOutputStream());
            os.writeUTF("Hi..This is Server");
            //closing connection
        }
        
        
    }
}
