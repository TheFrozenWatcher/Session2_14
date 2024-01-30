package Exercise;

import java.util.Random;
import java.util.Arrays;


public class Ex1 {
    public static void main(String[] args) {
        int[] array=new int[100];
        Random random=new Random();
        for (int i=0;i<array.length;i++){
            array[i]=random.nextInt(1000)+1;
        }
        System.out.println("Mảng số nguyên: "+Arrays.toString(array));
        int maxNumber=Arrays.stream(array).max().orElse(0);
        System.out.println("Số lớn nhất là "+maxNumber);
    }

}
