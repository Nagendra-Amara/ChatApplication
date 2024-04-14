
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



public class ClientOne{
    public static void main(String[] args)throws IOException {

        //Establishing a connection
        String host = "localhost";
        int port = 9999;
        Socket s = new Socket(host,port);


        //sending data from client to server
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeUTF("Hi from clientOne to server");
        

        DataInputStream in = new DataInputStream(s.getInputStream());
        System.out.println(in.readUTF());
        
       

        //closing all connections
        s.close();
        
    }
}