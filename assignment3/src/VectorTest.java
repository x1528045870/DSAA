public class VectorTest {
    public static void main(String[] args) {
        Vector v1 = new Vector(1, -2, 3);
        Vector v2 = new Vector(-5, 2, 2);
        System.out.println("quadrant of v1 is " + v1.quadrant());
        System.out.println("quadrant of v2 is " + v2.quadrant());
        System.out.printf("Area %.5f\n", v1.area(v2));
        System.out.printf("Area %.5f\n", Vector.area(v1,v2));
        System.out.println(v1.add(v2));
        System.out.println(Vector.add(v1, v2));
    }
}
