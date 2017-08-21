package price.server.network;
import java.io.*;
import java.net.*;

import price.common.command.Command;
import price.common.model.IPriceModel;

public class CommandServer {
    private int port;
    private ServerSocket serverSocket;
    private IPriceModel broker;
    
    public CommandServer(int port, IPriceModel broker) {
        this.port = port;
        this.broker = broker;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println
                    ("CmdServer created ServerSocket on port " + port);
            this.acceptConnection();
        } catch(Exception e) {
            System.out.println("CmdServer ctor: " + e);
        }
    }
    
    public void acceptConnection() {
        Socket skt;
        System.out.println("CmdServer.acceptConnection ");
        while(true) {
            try {
                skt = serverSocket.accept(); // listening;
                System.out.println("Connection + accepted");
                service(skt);
            } catch(Exception e) {
                System.out.println("CmdServer.acceptConnection: " + e);
            }
        }
    }
    
    private void service(Socket socket) {
        InputStream is;
        ObjectInputStream ois;
        OutputStream os;
        ObjectOutputStream oos;
        try {
            is = socket.getInputStream();
            ois = new ObjectInputStream(is);
            os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            while (true) {
                Command cmd = (Command) ois.readObject();
                System.out.println("CmdServer.service " + cmd);
                cmd.execute(broker);
                oos.writeObject(cmd);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
