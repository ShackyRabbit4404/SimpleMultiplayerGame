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
            g.fillOval(p.getX(),p.getY(),20,20);
            g.setColor(Color.BLACK);
            g.drawString(p.getName(),p.getX()-3,p.getY() + 30);
        }
        players=new Client().getPlayers();
    }
    public void getAndSetInfo(){
        int x = new Client().getX(name);
        int y = new Client().getY(name);
        if(W == true && y > 0 && isTouching(0,-5) == false)
             new Client().changeY(-5,name);
        if(A == true && x > 0 && isTouching(-5,0) == false)
             new Client().changeX(-5,name);
        if(S == true && y < 1080 && isTouching(5,0) == false)
             new Client().changeY(5,name);
        if(D == true && x < 1910 && isTouching(0,5) == false)
             new Client().changeX(5,name);    
    }
    public boolean isTouching(int x,int y){
        Rectangle r1 = new Rectangle(new Client().getX(name) + x,new Client().getY(name) + y,20,20);
        for(Player p: players){
            if(!p.getName().equals(name)){
                Rectangle r2 = new Rectangle(p.getX(),p.getY(),20,20);
                if(r1.intersects(r2))
                    return true;
            }
        }
        return false;
    }
}