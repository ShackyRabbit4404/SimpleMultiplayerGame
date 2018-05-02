import java.net.*;
import java.io.*;
import java.util.*;
public class serverRunnable implements Runnable {
    BufferedReader din;
    Socket client;
    PrintStream ps;
    OutputStream os;
    ArrayList<Player> players;
    Server server;
    public serverRunnable(Socket clientsocket, Server serv) {
        client = clientsocket;
        server=serv;
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
            //System.out.println("Message recieved: " + line);
        } catch (Exception e) {
            e.printStackTrace();
        }        
        if (line.substring(0,1).equals("c")) {
            String line2=line.substring(4);
            String name = line2.substring(0,line2.indexOf(":"));
            int amount = Integer.parseInt(line2.substring(line2.indexOf(":")+1));
            if (line.substring(2,3).equals("x")) {
                //change player x
                //System.out.println("changing " + name + " x location");
                server.changePX(name, amount);
            } else if (line.substring(2,3).equals("y")) {
                //change player y
                //System.out.println("changing " + name + " y location");
                server.changePY(name, amount);
            }
        } else if (line.substring(0,1).equals("a")) {
            String name = line.substring(4);
            if (line.substring(2,3).equals("p")) {
                //create new player
                server.addPlayer(name);
            }
        } else if (line.substring(0,1).equals("g")) {
            int ret = 0;
            if (line.substring(2,3).equals("x")) {
                //get player x
                String name = line.substring(4);
                ret=server.getPX(name);
                ps.println(ret);
            } else if (line.substring(2,3).equals("y")) {
                //get player y
                String name = line.substring(4);
                ret=server.getPY(name);
                ps.println(ret);
            } else if (line.substring(2,3).equals("p")) {
                ArrayList<String> res = server.getPlayers();
                for (String s : res) {
                    System.out.println(s);
                    ps.println(s);
                }
            }
        } 
    }
}