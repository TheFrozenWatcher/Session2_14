package Exercise;

import java.util.Arrays;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        List<String> originalString= Arrays.asList("ABC","CNX","OMG","IDF","WHO","CITY");
        List<String> newString= originalString.stream().sorted().toList();
        System.out.println("Các chuỗi đã sắp xếp "+newString);
    }
}
