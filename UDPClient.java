import java.net.*;
import java.io.*;
import java.util.*;
public class UDPClient {
    private DatagramSocket socket;
    private InetAddress address;    
    private byte[] buf;    
    public UDPClient() {
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");        
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void changeX(int a, String name) {
        
    }
    public void changeY(int a, String name) {
        
    }
    public ArrayList<Player> getPlayers() {
        return null;
    }
}
    
    
