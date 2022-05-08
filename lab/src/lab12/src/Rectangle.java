package lab12.src;

public class Rectangle extends Shape{

    private double width;
    private double height;
    public Rectangle(double x, double y) {
        super(x,y);
    }
    public Rectangle(double x, double y, double width, double height) {
        setXY(x,y);
        this.width = width;
        this.height = height;
    }

    public static void setScreenSize(int screenSize) {
         setScreenSize(screenSize);
    }
    public void checkColor() {
        if (isInBoundary()) {
            setColor(ShapeColor.GREEN);
        } else {setColor(ShapeColor.RED);
        }
    }
    public boolean isInBoundary() {
        if (-1 * getScreenSize()> getX() - this.width / 2 || getScreenSize() < getX()
                + this.width / 2) {
            return false;
        }
        if (-1 * getScreenSize() > getY() - this.height / 2 || getScreenSize() < getY()
                + this.height / 2) {
            return false;
        }
        return true;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String toString() {
        return "Rectangle{" + "width=" + width + ", height=" + height + " x=" + getX() +
                ", y=" + getY() + ", color=" + getColor()+ "}\n";
    }
    public void draw() {
        StdDraw.setPenColor(super.getColor().getColor());
        StdDraw.filledRectangle(getX(), getY(), this.width / 2, this.height / 2);
    }
}


