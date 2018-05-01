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
            g.setColor(new Color(0,208,255));
            g.drawString(p.getName(),p.getX(),p.getY() + 15);
        }
    }
    public void getAndSetInfo(){
        int x = client.getX(name);
        int y = client.getY(name);
        if(W == true && y > 0)
             client.changeY(-1,name);
        if(A == true && x > 0)
             client.changeX(-1,name);
        if(S == true && y < 1080)
             client.changeY(1,name);
        if(D == true && x < 1910)
             client.changeX(1,name);    
    }
}