public class Player{
    private String name;
    private int X;
    private int Y;
    public Player(String n, int x, int y){
        name  = n;
        X = x;
        Y = y;
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
}