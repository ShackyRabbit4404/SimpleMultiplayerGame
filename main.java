import javax.swing.*;
import cs1.*;
public class main{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        String name = Keyboard.readString();
        display screen = new display(name);
        frame.add(screen);
        keyboard listener = new keyboard(screen);
        frame.addKeyListener(listener);
        while(true == true){
            screen.getAndSetInfo();
            screen.repaint();
        }
    }
}