public class Player{
    private String name;
    private int X;
    private int Y;
    private int size;
    public Player(String n, int x, int y){
        name  = n;
        X = x;
        Y = y;
        size = 10;
    }
    public String getName(){
        return name;
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public void setX(int x){
        X = x;
    }
    public void setY(int y){
        Y = Y;
    }
    public int getSize(){
        return size;
    }
    public void setSize(int s){
        size = s;
    }
    public void change(int s){
        size += s;
    }
}