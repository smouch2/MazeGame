
public class Key {

    public static final int TILE_SIZE = 32;
    public static boolean keyValue = false;
    private static int x;
    private static int y;
    private static String image;

    public static void start(int x, int y) {
        Key.x = x;
        Key.y = y;
        image = "Assets/key.png";
    }
    public static void draw() {
        if (keyValue == false){
            int tileX = x * TILE_SIZE + TILE_SIZE/2;
            int tileY = y * TILE_SIZE + TILE_SIZE/2;
            StdDraw.picture(tileX, tileY, image);
        }
    }
    public static void update(){
            draw();         //update key
        if ( Key.isTouchingKey()) {
            keyValue = true;
        }
    }
    public static int getX() {
        return x;
    }
    public static int getY() {
        return y;
    }
    public static boolean isTouchingKey() {
        return (Player.getX() == Key.getX() && Player.getY() == Key.getY() );       
    }
}