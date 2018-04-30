import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
public class keyboard extends KeyAdapter
{
    display screen;
    public keyboard(display d)
    {
        screen = d;
    }
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W)
            screen.W = true;
        if(key == KeyEvent.VK_A)
            screen.A = true;
        if(key == KeyEvent.VK_S)
            screen.S = true;
        if(key == KeyEvent.VK_D)
            screen.D = true;
    }
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W)
            screen.W = false;
        if(key == KeyEvent.VK_A)
            screen.A = false;
        if(key == KeyEvent.VK_S)
            screen.S = false;
        if(key == KeyEvent.VK_D)
            screen.D = false;
    }
}