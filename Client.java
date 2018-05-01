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
        ps.println("c:x:" + name + ":" + a);
        ps.flush();
    }
    public void changeY(int a,String name){
        ps.println("c:y:" + name + ":" + a);
        ps.flush();
    }
    public ArrayList<Player> getPlayers(){
        return new ArrayList<Player>();
    }
    public void addPlayer(String name){
        ps.println("a:p:" + name);
        ps.flush();
    }
    public int getX(String name) {
        ps.println("g:x:" + name);
        try {
            return (Integer.parseInt(din.readLine()));
        } catch (Exception e) {
            return -99;
        }
    }
    public int getY(String name) {
        ps.println("g:y:" + name);
        try {
            return (Integer.parseInt(din.readLine()));
        } catch (Exception e) {
            return -99;
        }
    }
}