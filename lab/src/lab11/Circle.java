package lab11;

import lab11.ShapeColor;

import java.awt.*;

public  class Circle extends Shape implements Comparable<Circle>,ColorDraw{
    private double radius;
    private double x;
    private double y;
    static final int DEFAULT_RADIUS = 5;
    private static int screenSize = 10;
    private lab11.ShapeColor color = lab11.ShapeColor.GRAY;
    @Override
    public void customizedColor(ColorScheme colorScheme, int index) {
        Color[] colorList = colorScheme.getColorScheme();
        if (index < 0){
            index = 0;
        }
        if (index >= colorList.length){
            index = index % colorList.length;
        }
        StdDraw.setPenColor(colorList[index]);
        StdDraw.filledCircle(Shape.getX(), Shape.getY(), radius);
    }

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
            color = lab11.ShapeColor.GREEN;
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



    public void setX(double x) {
        this.x = x;
    }



    public void setY(double y) {
        this.y = y;
    }

    public void draw() {

        StdDraw.setPenColor(color.getColor());
        StdDraw.filledCircle(x, y, radius);

    }

    @Override
    public int compareTo(Circle o) {
        return 0;
    }
}
