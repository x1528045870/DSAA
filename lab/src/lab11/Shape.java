package lab11;

import java.awt.*;

public class Shape {
    private double x;
    private double y;
    private ShapeColor color = ShapeColor.GRAY;
    private static int screenSize = 10;
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Shape() {
    }

    protected static double getY() {
        return 0;
    }

    protected static double getX() {
        return 0;
    }


    public void setX(double x) {
        this.x = x;
    }



    public void setY(double y) {
        this.y = y;
    }

    public ShapeColor getColor() {
        return color;
    }

    public void setColor(ShapeColor color) {
        this.color = color;
    }

    public static int getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(int screenSize) {
        Shape.screenSize = screenSize;
    }
    public String toString() {
        return " x=" + x + ", y=" + y + ", color=" + color;
    }
}
