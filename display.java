import java.awt.*;
import javax.swing.*;
import java.util.*;
public class display extends JPanel{
    boolean W = false;
    boolean A = false;
    boolean S = false;
    boolean D = false;
    String name;
    ArrayList<Player> players = new ArrayList<Player>();
    public display(String n){
        super();
        name = n;
        new Client().addPlayer(name);
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
            new Client().changeY(-1,name);
        if(A == true)
            new Client().changeX(-1,name);
        if(S == true)
            new Client().changeY(1,name);
        if(D == true)
            new Client().changeX(1,name);
        players = new Client().getPlayers();
    }
}