package lab12.src;

import java.awt.*;

public class Circle extends Shape implements Comparable<Circle> , ColorDraw{
    private double radius;
    private double x;
    private double y;
    static final int DEFAULT_RADIUS = 5;
    private static int screenSize = 10;
    private ShapeColor color = ShapeColor.GRAY;

    public Circle(double radius, double x, double y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public Circle(double radius) {
        this.radius = radius;
        this.x = 0;
        this.y = 0;
    }

    public Circle(double x, double y) {
        this.radius = DEFAULT_RADIUS;
        this.x = x;
        this.y = y;
    }

    public static int getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(int screenSize) {
        Circle.screenSize = screenSize;
    }

    public void checkColor() {
        if (isInBoundary()) {
            color = ShapeColor.GREEN;
        } else {
            color = ShapeColor.RED;
        }
    }

    public boolean isInBoundary() {
        if (-1 * Circle.screenSize > this.x - this.radius || Circle.screenSize < this.x + this.radius) {
            return false;
        }
        if (-1 * Circle.screenSize > this.y - this.radius || Circle.screenSize < this.y + this.radius) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + " x=" + x +
                ", y=" + y +
                ", color=" + color +
                "}\n";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

     public void draw()
   {

       StdDraw.setPenColor(color.getColor());
       StdDraw.filledCircle(x, y, radius);

   }

    @Override
    public int compareTo(Circle o ){
        if (this.radius<o.radius){
            return 1;
        }else if (this.radius > o.radius){
            return -1;
        }
        return 0;
    }

    @Override
    public void customizedColor(ColorScheme colorScheme, int x){
        Color[] colors = colorScheme.getColorScheme();
        if (x < 0){
            x=0;
        }
        if (x >= colors.length){
            x = x%colors.length;
        }
        StdDraw.setPenColor(colors[x]);
        StdDraw.filledCircle(this.x,this.y,radius);
    }
}
