
import java.util.Collections;
import java.util.List;

public class MinMaxFinder {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 4, 3, 2, 1, 20);

        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
