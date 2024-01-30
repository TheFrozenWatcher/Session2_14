package Exercise;

import java.util.Arrays;
import java.util.Random;

public class Ex6 {
    public static void main(String[] args) {
        int[] array = new int[3];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        System.out.println("Mảng số nguyên: " + Arrays.toString(array));
        boolean result = Arrays.stream(array).anyMatch(number -> number % 2 == 0);
        if (result) {
            System.out.println("Mảng có chứa số chẵn");
        } else {
            System.out.println("Mảng không chứa số chẵn");

        }
    }
}
