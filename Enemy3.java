public class Enemy3 {

    public static final int TILE_SIZE = 32;
    private static int x;
    private static int y;
    public static String image;
    private static long time;
    //boolean for present default false
// boolean set to true when start method called
//check for before draw in random


    public static void start(int x, int y) {
        Enemy3.x = x;
        Enemy3.y = y;
        image = "Assets/troll3.png";
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
            Enemy3.move();
        }
        if ( Enemy3.isTouchingEnemy3()) {
            Enemy3.move();
            MazeGame.dropHealth();
        } 
    }
    private static void move(){
        int enemy3Choice = (int) (Math.random()*4);
            switch (enemy3Choice){    
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
    public static boolean isTouchingEnemy3() {
        return Player.getX() == Enemy3.getX() && Player.getY() == Enemy3.getY();
    }
    //public static boolean isDead() {
    //    return (Weapon.weaponValue && Enemy3.isTouchingEnemy3())==true;
    //}
}