import java.net.*;
import java.io.*;
import java.util.*;
public class Server implements Runnable {
    ServerSocket ss;
    Socket s;
    BufferedReader din;
    DataOutputStream dout;
    ArrayList<Player> players = new ArrayList<Player>();
    public static void main(String[] args) throws Exception {
        new Server();
    }
    public Server() {
        try {
            ss = new ServerSocket(11211);
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
    public void run() {
        while(true) {
            try {
                s = ss.accept();
                System.out.println("new connection from " + s.getInetAddress());
                (new Thread(new serverRunnable(s, this))).start();                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public int indexOfPlayer(String name) {
        for (int i=0;i<players.size();i++) {
            if (players.get(i).getName().equals(name)) {
                return i;
            }   
        }     
        return -1;
    }
    public void setPX(String name, int amt) {
        int in = indexOfPlayer(name);
        if (in!=-1) {
            players.get(in).setX(amt);
        }   
    }
    public void setPY(String name, int amt) {
        int in = indexOfPlayer(name);
        if (in!=-1) {
            players.get(in).setY(amt);
        }        
    }
    public void changePX(String name, int amt) {
        int in = indexOfPlayer(name);
        if (in!=-1) {
            players.get(in).setX(players.get(in).getX()+amt);
        }          
        System.out.println("changing x for " + name);
    }
    public void changePY(String name, int amt) {
        int in = indexOfPlayer(name);
        if (in!=-1) {
            players.get(in).setY(players.get(in).getY()+amt);
        }      
        System.out.println("changing y for " + name);
    }
    public int getPX(String name) {
        int in = indexOfPlayer(name);
        if (in!=-1) {
            //System.out.println(name + " x at " + players.get(in).getX());
            return players.get(in).getX();
        }
        return -1;
    }
    public int getPY(String name) {
        int in = indexOfPlayer(name);
        if (in!=-1) {
            //System.out.println(name + " y at " + players.get(in).getY());
            return players.get(in).getY();
        }
        return -1;        
    }
    public void addPlayer(String name) {
        players.add(new Player(name,0,0));
    }
    public ArrayList<String> getPlayers() {
        ArrayList<String> ret = new ArrayList<String>();
        for (Player p : players) {
            String ln = p.getName() + ":" + p.getX() + ":" + p.getY();
            ret.add(ln);
        }
        ret.add("{}{}{}");
        return ret;
    }
}