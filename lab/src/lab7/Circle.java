package lab7;
public class Circle {
    //定义Circle的属性。
    private double radius;
    private double x;
    private double y;
    //定义方法
    //这些是instance method 不需要static是动态的，用的是对象来调用。
    public double area() {
        return radius*radius*Math.PI;
    }
    public double perimeter () {
        return 2*Math.PI*radius;
    }
    public void position() {
        System.out.printf("Position of the circle is (%.1f,%.1f)\n",x,y);
    }
    //使其能在private下被访问
    public double getRadius() {
        return radius;
    }
    //getter and setter
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
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
}
