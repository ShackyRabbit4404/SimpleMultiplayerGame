import javax.swing.*;
import java.awt.*;
import cs1.*;
import java.util.*;
public class main{
    /*
    Boolean W = false;
    Boolean A = false;
    Boolean S = false;
    Boolean D = false;
    String name;
    ArrayList<Player> players=new ArrayList<Player>();
     */
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setBounds(new Rectangle(0,0,1920,1080));
        frame.setVisible(true);
        String name = Keyboard.readString();
        while(contains(new Client().getPlayers(),name) == false){
            System.out.println("That name already exists");
            name = Keyboard.readString();
        }
        display screen = new display(name);
        frame.add(screen);
        keyboard listener = new keyboard(screen);
        frame.addKeyListener(listener);
        try{
            while(true){
                screen.getAndSetInfo();
                screen.drawing();
                Thread.sleep(200);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static boolean contains(ArrayList<Player> players,String name){
        for(Player p: players){
            if(p.getName().equals(name))
                return true;
        }
        return false;
    }
    /*
    public void getAndSetInfo(){
    int x = new Client().getX(name);
    int y = new Client().getY(name);
    if(W == true && y >= 0)
    new Client().changeY(-1,name);
    if(A == true && x >= 0)
    new Client().changeX(-1,name);
    if(S == true && y <= 1080)
    new Client().changeY(1,name);
    if(D == true && x <= 1910)
    new Client().changeX(1,name);    
    }*/
}