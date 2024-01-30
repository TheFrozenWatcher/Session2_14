package Exercise;

import java.util.Arrays;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Mảng số nguyên: " + numbers);
        int result=numbers.stream().reduce(0,(a,b)->a+b);
        System.out.printf("Tổng của chuỗi "+result);
    }
}
