package Exercise;

import java.util.Arrays;
import java.util.List;

public class Ex7 {
    public static void main(String[] args) {
        List<String> originalString= Arrays.asList("Abx","Cacf","oMG","Iff","who","CiY");
        originalString=originalString.stream().map(string->string.toUpperCase()).toList();
        System.out.println(originalString);

    }
}
