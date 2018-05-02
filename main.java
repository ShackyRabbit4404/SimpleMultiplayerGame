import javax.swing.*;
import java.awt.*;
import cs1.*;
public class main{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setBounds(new Rectangle(0,0,1920,1080));
        frame.setVisible(true);
        String name = Keyboard.readString();
        display screen = new display(name);
        frame.add(screen);
        keyboard listener = new keyboard(screen);
        frame.addKeyListener(listener);
        while(true){
            screen.getAndSetInfo();
            screen.drawing();
        }
    }
}