package lab5;

public class array1 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = new int[5];

        array2[0] = 6;
        array2[1] = 7;
        array2[2] = 8;
        array2[3] = 9;
        array2[4] = 10;
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
        System.out.println();
        for (int e : array2) {
            System.out.print(e + "\t");
        }
        System.out.println();
        int[] array3 = {1, 2, 3, 4,};
        array3 = array2;
        for (int y : array3) {
            System.out.print(y + "\t");
        }
    }
}
