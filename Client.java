import java.util.*;
import java.net.*;
import java.io.*;
public class Client{
    Socket sock;
    PrintStream ps;
    BufferedReader din;
    InputStream is;
    
    public Client(){
        try {
            sock = new Socket("127.0.0.1", 11211);
            ps = new PrintStream(sock.getOutputStream());
            din = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            is = sock.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void changeX(int a,String name){
        ps.println("c:x:");
    }
    public void changeY(int a,String name){
        
    }
    public ArrayList<Player> getPlayers(){
        return new ArrayList<Player>();
    }
    public void addPlayer(String name){
        
    }
    public int getX(String name) {
        return 1;
    }
    public int getY(String name) {
        return 1;
    }

}