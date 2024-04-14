import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.net.Socket;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
public class Index extends JFrame implements ActionListener,Home
{
    JTextField text;
    JButton send;
    JTextArea messages;
    Socket s;
    String host;
    int port;
    DataOutputStream os;
    DataInputStream is;
    StringBuilder temp;
    Index() throws IOException
    {
        host = HOST;
        port = PORT;
        s = new Socket(host,port);
        temp = new StringBuilder();
        os = new DataOutputStream(s.getOutputStream());
        is = new DataInputStream(s.getInputStream());

        text = new JTextField();
        send = new JButton("Send");
        messages = new JTextArea();


        text.setBounds(400, 70, 150, 40);
        send.setBounds(400, 160, 80, 50);
        messages.setBounds(50, 70,300, 400);

        add(text);
        add(send);
        add(messages);

        send.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
    }
    public static void main(String[] args) throws IOException 
    {
        new Index();        
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String mess = text.getText();
        try 
        {
            os.writeUTF(mess);
            messages.setText(temp + mess+"\n");
            temp = new StringBuilder(messages.getText());
            messages.setText(temp + is.readUTF()+"\n");
            
            temp = new StringBuilder(messages.getText());
        } 
        catch (IOException e1) {
            System.exit(0);
        }
    }
}