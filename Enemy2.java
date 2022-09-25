public class Enemy2 {

    public static final int TILE_SIZE = 32;
    private static int x;
    private static int y;
    public static String image;
    private static long time;
    //boolean for present default false
// boolean set to true when start method called
//check for before draw in random


    public static void start(int x, int y) {
        Enemy2.x = x;
        Enemy2.y = y;
        image = "Assets/troll2.png";
    }
    public static void draw() {
        //if (!isDead()){
            int tileX = x * TILE_SIZE + TILE_SIZE/2;
            int tileY = y * TILE_SIZE + TILE_SIZE/2;
            StdDraw.picture(tileX, tileY, image);    
        //}
    }
    public static void update() {
        long now  = System.currentTimeMillis();
        if (now - time > 400){
            Enemy2.move();
        }
        if ( Enemy2.isTouchingEnemy2()) {
            Enemy2.move();
            MazeGame.dropHealth();
        } 
    }
    private static void move(){
        int enemy2Choice = (int) (Math.random()*4);
            switch (enemy2Choice){    
                case 0:
                    if (Scene.canMove(x+1, y)) {
                        x++;
                    }
                    break; 
                case 1:
                    if (Scene.canMove(x, y+1)) {
                        y++;
                    }
                    break;
                case 2: 
                    if (Scene.canMove(x-1, y)) {
                        x--;
                    }
                    break;
                case 3:
                    if ( Scene.canMove(x,y-1) ) {
                        y--;
                    }
                    break;
                }
                    
                time = System.currentTimeMillis();
            }
        
    public static int getX() {
        return x;
    }
    public static int getY() {
        return y;
    }
    public static boolean isTouchingEnemy2() {
        return Player.getX() == Enemy2.getX() && Player.getY() == Enemy2.getY();
    }
    //public static boolean isDead() {
    //    return (Weapon.weaponValue && Enemy2.isTouchingEnemy2())==true;
    //}
}