package Exercise;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        System.out.println("Mảng số nguyên " + Arrays.toString(array));
        System.out.println("Nhập giá trị cần lọc");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int[] filteredArray = Arrays.stream(array).filter(number -> number > value).toArray();
        Arrays.stream(filteredArray).forEach(number->System.out.println(number));
    }
}
