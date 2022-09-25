public class Enemy {
    
    public static final int TILE_SIZE = 32;
    private static int x;
    private static int y;
    private static String image;
    private static long time;


    public static void start(int x, int y) {
        Enemy.x = x;
        Enemy.y = y;
        image = "Assets/troll.png";
    }
    public static void draw() {
        //if (isDead()){
        int tileX = x * TILE_SIZE + TILE_SIZE/2;
        int tileY = y * TILE_SIZE + TILE_SIZE/2;
        StdDraw.picture(tileX, tileY, image);    
        //}
        
    }
    public static void update() {
        long now  = System.currentTimeMillis();
        if (now - time > 400){
            Enemy.move();
        }
        if ( Enemy.isTouchingEnemy()) {
            Enemy.move();
            MazeGame.dropHealth();
        } 
    }
    public static void move(){
        int enemyChoice = (int) (Math.random()*4);
            switch (enemyChoice){    
                case 0:
                    if ( Scene.canMove(x,y-1) ) {
                        y--;
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
                    if (Scene.canMove(x+1, y)) {
                        x++;
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
    public static boolean isTouchingEnemy() {
        return Player.getX() == Enemy.getX() && Player.getY() == Enemy.getY();
    }
    //public static boolean isDead() {
    //    return (Weapon.weaponValue == Enemy.isTouchingEnemy())==true;
    //}
}