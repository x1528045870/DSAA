import java.util.Scanner;

public class Lab22 {
    public static void main(String[] args) {
        float width;
        float height;
        float area;
        float perimeter;
    Scanner input = new Scanner(System.in);

    System.out.print("Enter width:");
    width =input.nextFloat();
    System.out.print("Enter height:");
    height = input.nextFloat();
    area=width*height;
    perimeter=2*(width+height);
    System.out.printf("The area is %.2f.\n",area);
    System.out.printf("The perimeter is %.2f.",perimeter);
    }
}
