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
            System.out.println("Message recieved: " + line);
        } catch (Exception e) {
            e.printStackTrace();
        }        
        if (line.substring(0,1).equals("c")) {
            line=line.substring(4);
            String name = line.substring(0,line.indexOf(":"));
            int amount = Integer.parseInt(line.substring(line.indexOf(":")+1));
            if (line.substring(2,3).equals("x")) {
                //change player x
                server.changePX(name, amount);
            } else if (line.substring(2,3).equals("y")) {
                //change player y
                server.changePY(name, amount);
            }
        } else if (line.substring(0,1).equals("a")) {
            String name = line.substring(4);
            if (line.substring(2,3).equals("p")) {
                //create new player
                server.addPlayer(name);
            }
        } else if (line.substring(0,1).equals("g")) {
            String name = line.substring(4);
            int ret = 0;
            if (line.substring(2,3).equals("x")) {
                //get player x
                ret=server.getPX(name);
                ps.println(ret);
            } else if (line.substring(2,3).equals("y")) {
                //get player y
                ret=server.getPY(name);
                ps.println(ret);
            } else if (line.substring(2,3).equals("p")) {
                ArrayList<String> res = server.getPlayers();
                for (String s : res) {
                    ps.println(s);
                }
            }
        } 
    }
}