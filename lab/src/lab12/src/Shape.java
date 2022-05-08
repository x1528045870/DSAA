package lab12.src;

public abstract class Shape {
    private double x = 0;
    private double y = 0;
    private static int screenSize = 10;
    private ShapeColor color = ShapeColor.GRAY;

    public Shape(){}
    public Shape(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static void setScreenSize(int a){
        screenSize = a;
    }

    public void setXY(double x,double y){
        this.x = x;
        this.y = y;
    }

    public void setColor(ShapeColor a){
        color = a;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public ShapeColor getColor(){
        return color;
    }

    public static int getScreenSize(){
        return screenSize;
    }

    public void checkColor() {

    }

    abstract public void draw() ;


}
