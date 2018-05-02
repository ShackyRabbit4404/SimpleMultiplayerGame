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
        players = new Client().getPlayers();
        /*while(true){
            getAndSetInfo();
            drawing();
        }*/
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
            g.fillRect(p.getX(),p.getY(),20,20);
            g.setColor(Color.BLACK);
            g.drawString(p.getName(),p.getX()-3,p.getY() + 30);
        }
        players=new Client().getPlayers();
    }
    public void getAndSetInfo(){
        int x = new Client().getX(name);
        int y = new Client().getY(name);
        if(W == true && y >= 0)
             new Client().changeY(-5,name);
        if(A == true && x >= 0)
             new Client().changeX(-5,name);
        if(S == true && y <= 1080)
             new Client().changeY(5,name);
        if(D == true && x <= 1910)
             new Client().changeX(5,name);    
    }
}