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
            sock = new Socket("10.1.200.117", 11211);
            ps = new PrintStream(sock.getOutputStream());
            din = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            is = sock.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void changeX(int a,String name){
        ps.println("c:x:" + name + ":" + a);
    }
    public void changeY(int a,String name){
        ps.println("c:y:" + name + ":" + a);
    }
    public ArrayList<Player> getPlayers(){
        String line = "";
        ArrayList<Player> ret = new ArrayList<Player>();
        try {
            while(!line.equals("{}{}{}")) {
                line=din.readLine();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
    public void addPlayer(String name){
        ps.println("a:p:" + name);
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