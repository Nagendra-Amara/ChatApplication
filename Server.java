import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException{
        
        //creating a socket to connect client from server
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();

        //reading data from socket sent by client 
        Scanner sc = new Scanner(new InputStreamReader(s.getInputStream()));
        String str = sc.nextLine(); 
        System.out.println(str);

        
        //closing connection
        sc.close();
        ss.close();
    }
}
