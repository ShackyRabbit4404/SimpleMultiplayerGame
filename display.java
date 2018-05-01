import java.awt.*;
import javax.swing.*;
import java.util.*;
public class display extends JPanel{
    boolean W = false;
    boolean A = false;
    boolean S = false;
    boolean D = false;
    String name;
    Server server = new Server();
    ArrayList<Player> players = new ArrayList<Player>();
    public display(String n){
        super();
        name = n;
        server.addPlayer(name);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0,0,1920,1080);
        for(Player p: players){
            g.setColor(Color.RED);
            g.drawRect(p.X,p.Y,10,10);
            g.setColor(Color.BLACK);
            g.drawString(p.name,p.X,p.Y + 15);
        }
    }
    public void getAndSetInfo(){
        if(W == true)
            server.changeY(-1,name);
        if(A == true)
            server.changeX(-1,name);
        if(S == true)
            server.changeY(1,name);
        if(D == true)
            server.changeX(1,name);
        players = server.getPlayers();
    }
}