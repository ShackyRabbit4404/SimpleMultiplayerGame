import java.awt.*;
import javax.swing.*;
import java.util.*;
public class display extends JPanel{
    boolean W = false;
    boolean A = false;
    boolean S = false;
    boolean D = false;
    String name;
    Client client = new Client();
    ArrayList<Player> players = new ArrayList<Player>();
    public display(String n){
        super();
        name = n;
        client.addPlayer(name);
        players = client.getPlayers();
    }
    public void drawing(){
        repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0,0,1920,1080);
        for(Player p: players){
            g.setColor(Color.RED);
            g.drawRect(p.getX(),p.getY(),10,10);
            g.setColor(Color.BLACK);
            g.drawString(p.getName(),p.getX(),p.getY() + 15);
        }
    }
    public void getAndSetInfo(){
        if(W == true)
             client.changeY(-1,name);
        if(A == true)
             client.changeX(-1,name);
        if(S == true)
             client.changeY(1,name);
        if(D == true)
             client.changeX(1,name);    
    }
}