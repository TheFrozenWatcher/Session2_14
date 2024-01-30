package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ex2 {
    public static void main(String[] args) {
//        Random random = new Random();
//        int[] array = new int[10];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt();
//        }
//        System.out.println("Mảng số nguyên: " + Arrays.toString(array));
//        int[] evenNumbers= Arrays.stream(array).filter(arr->arr%2==0).toArray();
//        System.out.println("Mảng số chẵn: " + Arrays.toString(evenNumbers));

        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Mảng số nguyên: " + numbers);
        List<Integer> evenNumbers=numbers.stream().filter(number->number%2==0).collect(Collectors.toList());
        System.out.println("Mảng số chẵn: " + evenNumbers);


    }
}
