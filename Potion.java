
public class Potion {

    public static final int TILE_SIZE = 32;
    public static boolean PotionValue = false;
    private static int x;
    private static int y;
    private static String image;

    public static void start(int x, int y) {
        Potion.x = x;
        Potion.y = y;
        image = "Assets/Potion.png";
    }
    public static void draw() {
        if (PotionValue == false){
            int tileX = x * TILE_SIZE + TILE_SIZE/2;
            int tileY = y * TILE_SIZE + TILE_SIZE/2;
            StdDraw.picture(tileX, tileY, image);
        }
    }
    public static void update(){
            draw();         //update Potion
        if ( Potion.isTouchingPotion() && MazeGame.health < 7) {
            PotionValue = true;
            MazeGame.raiseHealth();
        }
    }
    public static int getX() {
        return x;
    }
    public static int getY() {
        return y;
    }
    public static boolean isTouchingPotion() {
        return (Player.getX() == Potion.getX() && Player.getY() == Potion.getY() );       
    }
}