package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số nguyên x:");
        int x=sc.nextInt();
        System.out.println("Nhập số nguyên y:");
        int y=sc.nextInt();
        List<Integer> numbers= IntStream.range(x,y+1).boxed().collect(Collectors.toList());
        System.out.println("Danh sách số nguyên giữa "+x+" và "+y+": "+numbers);
    }
}
