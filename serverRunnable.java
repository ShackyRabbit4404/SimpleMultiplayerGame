import java.net.*;
import java.io.*;
import java.util.*;
public class serverRunnable implements Runnable {
    BufferedReader din;
    Socket client;
    PrintStream ps;
    OutputStream os;
    ArrayList<Player> players;
    public serverRunnable(Socket clientsocket) {
        client = clientsocket;
        try {
            ps = new PrintStream(client.getOutputStream());
            os = client.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    public void run() {
        String line = "";
        try {
            din = new BufferedReader(new InputStreamReader(client.getInputStream()));               
            line = din.readLine();
            System.out.println("Message recieved: " + line);
        } catch (Exception e) {
            e.printStackTrace();
        }        
        if (line.substring(0,1).equals("c")) {
            String name = line.substring(4,line.indexOf(":"));
            line=line.substring(4);
            int amount = line.substring(line.indexOf);
            if (line.substring(2,3).equals("x")) {
                for (Player p : players) {
                    if (p.getName().equals(name)) {
                        p.setX(p.getX());
                        
                        
                        break;
                    }
                    
                }
                    
            } else if (line.substring(2,3).equals("y")) {
                for (Player p : players) {
                    if (p.getName().equals(name)) {
                        
                        break;
                    }
                    
                    
                }
                
            }
        } else if (line.substring(0,1).equals("a")) {
            if (line.substring(2,3).equals("p")) {
                
            }
        } else if (line.substring(0,1).equals("g")) {
            if (line.substring(2,3).equals("x")) {
                
            } else if (line.substring(2,3).equals("y")) {
                
            }
        }
        
        
        
        
    }
}