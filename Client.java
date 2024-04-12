import java.io.IOException;

import java.io.OutputStreamWriter;
import java.net.Socket;


public class Client{
    public static void main(String[] args)throws IOException {

        //Establishing a connection
        String host = "192.168.1.56";
        int port = 9999;
        Socket s = new Socket(host,port);


        //sending data from client to server
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        os.write("Hi from client to server");
        os.flush();


        


        //closing all connections
        s.close();
        os.close();
    }
}