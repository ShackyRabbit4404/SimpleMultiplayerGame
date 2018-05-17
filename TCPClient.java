import java.net.*;
import java.io.*;
import java.util.*;
public class TCPClient {
    private DatagramSocket socket;
    private InetAddress address;    
    private byte[] buf;    
    public TCPClient() {
        //really UDPClient
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void changeX(int a, String name) throws Exception{
        String line="c:x:" + name + ":" + a;
        buf = line.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 11211); 
        socket.send(packet);
    }
    public void changeY(int a, String name) throws Exception{
        String line="c:y:" + name + ":" + a;
        buf = line.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 11211); 
        socket.send(packet);      
    }
    public ArrayList<Player> getPlayers() throws Exception{
        String line2="g:p";
        buf = line2.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 11211); 
        socket.send(packet);  
        String line = "";
        ArrayList<Player> ret = new ArrayList<Player>();
        while(!line.equals("{}{}{}")) {
            packet = new DatagramPacket(buf,buf.length);
            socket.receive(packet);
            line = new String(packet.getData(),0,packet.getLength());
            System.out.println(line);
            if (!line.equals("{}{}{}")) {
                //name:x:y
                String name=line.substring(0,line.indexOf(":"));
                line=line.substring(line.indexOf(":")+1);
                int x = Integer.parseInt(line.substring(0,line.indexOf(":")));
                int y = Integer.parseInt(line.substring(line.indexOf(":")+1));
                ret.add(new Player(name,x,y));
            }
        }        
        return ret;
    }
    public void addPlayer(String name) throws Exception {
        String line="a:p:" + name;
        buf = line.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 11211); 
        socket.send(packet);
    }
    public int getX(String name) throws Exception {
        String line="g:x:" + name;
        buf = line.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 11211); 
        socket.send(packet);
        packet = new DatagramPacket(buf,buf.length);
        socket.receive(packet);
        String received = new String(packet.getData(),0,packet.getLength());
        return Integer.parseInt(received);
    }
    public int getY(String name) throws Exception{
        String line="g:y:" + name;
        buf = line.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 11211); 
        socket.send(packet);
        packet = new DatagramPacket(buf,buf.length);
        socket.receive(packet);
        String received = new String(packet.getData(),0,packet.getLength());
        return Integer.parseInt(received);
    }
}
    
    
