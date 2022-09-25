import java.util.ArrayList;
import java.util.Arrays;

public class MazeGame{
    public static boolean gameOver;
    public static int health = 7;
    private static int level;
    public static String endMess[] = new String[3];
    
    public static void main(String[] args) {
        start();
        messageArray();
        while (gameOver == false) {
            render();
            update();
        }
        if (gameOver == true){
            System.exit(0);
        }
            
            //String message0 = endMess.get(0);
            //String message1 = endMess.get(1);
            //String message2 = endMess.get(2);
            
        
    }
    public static void messageArray() {
            //endMess[] = {"You have escaped to lay eggs another day.", "The troll has eaten your delicious insides!", "The door is locked.  Find the key!"};
            endMess[0] = "You have escaped the dungeon to freedom and the land beyond.";
            //endMess.add("You have escaped to lay eggs another day.");
            endMess[1] = "The troll has eaten your delicious insides!";
            //endMess.add("The troll has eaten your delicious insides!");
            endMess[2] = "The door is locked.  Find the key!";
            //endMess.add("The door is locked.  Find the key!");
        
    }
    
    public static void start() {
        gameOver = false;
        level = 0;
        World.start();
        Scene.start(level);
    }
    public static void render() {
        Scene.draw();
        Player.draw();
        Potion.draw();
        Enemy.draw();
        Enemy2.draw();
        Exit.draw();
        Key.draw();
        Enemy3.draw();
        
        StdDraw.text(32,10,"health: " + health);
        StdDraw.text(160,10, "key in possession: " + Key.keyValue);
        StdDraw.show(100);
    }
    
    public static void update() {
        Player.update();
        Key.update();
        Potion.update();
        Enemy3.update();
        Enemy.update();
        Enemy2.update();
        if (Key.keyValue && Exit.isTouchingExit()) {
            level++;
            if (level == World.getLength() ){
                //System.out.println("You have escaped to lay eggs another day.");
                //System.out.print(endMess.get(0));
                System.out.print(endMess[0]);
                gameOver = true;
                
            }
            else if (!Key.keyValue && Exit.isTouchingExit()) {
                //System.out.println(endMess.get(2));
                //System.out.println("The door is locked.  Find the key!");
                System.out.print(endMess[2]);
            }
            else {
                Scene.start(level);
                Key.keyValue = false;
                Potion.PotionValue = false;
                //gem values 1,2,3 = true again
            }
        }
        
        //isTouching for key contact
        //isTouching for enemy contact
        
            //isTouching boolean foEnemy3 value
 
    }
    

    public static void dropHealth() {
        health--;        //decrement health
    
        if (health == 0){
            //System.out.println("The troll has eaten your delicious insides!");
            //System.out.println(endMess.get(1));
            System.out.print(endMess[1]);
            gameOver = true;
            
        }
    }
    public static void raiseHealth() {
        
        if (health < 5){
            health = health +3;
        }

        
    }
   
}