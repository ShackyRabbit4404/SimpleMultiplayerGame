public class stress{
    public static void main(String[] args) {
        for(int i=0;i<100;i++) {
            new Client().addPlayer(i+""); 
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while(true) {
            for (int i=0;i<100;i++) {
                new Client().changeX((int)Math.random()+4, i+"");
                new Client().changeY((int)Math.random()+4, i+"");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }        
    }
}