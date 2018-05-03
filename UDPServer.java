import java.net.*;
import java.io.*;
import java.util.*;
public class UDPServer {
    private DatagramSocket socket;
    private InetAddress address;    
    private byte[] buf;  
    ArrayList<Player> players = new ArrayList<Player>();
    public UDPServer() {
        try {
            socket = new DatagramSocket(11211);
        } catch (Exception e) {
            e.printStackTrace();
        }
        run();        
    }
    public void run() {
        while(true) {
            try {
                DatagramPacket packet = new DatagramPacket(buf,buf.length);
                socket.receive(packet);
                address = packet.getAddress();
                String line = new String(packet.getData(), 0, packet.getLength());
                if (line.substring(0,1).equals("c")) {
                    String line2=line.substring(4);
                    String name = line2.substring(0,line2.indexOf(":"));
                    int amount = Integer.parseInt(line2.substring(line2.indexOf(":")+1));
                    if (line.substring(2,3).equals("x")) {
                        //change player x
                        //System.out.println("changing " + name + " x location");
                        changePX(name, amount);
                    } else if (line.substring(2,3).equals("y")) {
                        //change player y
                        //System.out.println("changing " + name + " y location");
                        changePY(name, amount);
                    }
                } else if (line.substring(0,1).equals("a")) {
                    String name = line.substring(4);
                    if (line.substring(2,3).equals("p")) {
                        //create new player
                        addPlayer(name);
                    }
                } else if (line.substring(0,1).equals("g")) {
                    int ret = 0;
                    if (line.substring(2,3).equals("x")) {
                        //get player x
                        String name = line.substring(4);
                        ret=getPX(name);
                        buf = (ret+"").getBytes();
                        DatagramPacket packet2 = new DatagramPacket(buf, buf.length, address, 11211); 
                        socket.send(packet);
                    } else if (line.substring(2,3).equals("y")) {
                        //get player y
                        String name = line.substring(4);
                        ret=getPY(name);
                        buf = (ret+"").getBytes();
                        DatagramPacket packet2 = new DatagramPacket(buf, buf.length, address, 11211); 
                        socket.send(packet);
                    } else if (line.substring(2,3).equals("p")) {
                        ArrayList<String> res = getPlayers();
                        for (String s : res) {
                            System.out.println(s);
                            buf = (s).getBytes();
                            DatagramPacket packet2 = new DatagramPacket(buf, buf.length, address, 11211); 
                            socket.send(packet);
                        }
                }
            }
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
        //System.out.println("changing x at index " + in);
        if (in!=-1) {
            Player p = players.get(in);
            players.set(in, new Player(p.getName(),p.getX()+amt,p.getY()));
        }          
        // System.out.println("changing x for " + name);
    }
    public void changePY(String name, int amt) {
        int in = indexOfPlayer(name);
        //System.out.println("changing x at index " + in);
        if (in!=-1) {
            Player p = players.get(in);
            players.set(in, new Player(p.getName(),p.getX(),p.getY()+amt));
        }      
        //System.out.println("changing y for " + name);
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