import java.util.Arrays;
import java.util.List;

public class Task4_stream {


    public static void main(String[] args) {
        List<Integer> numbers =Arrays.asList(1, 3, 6, 2, 2, 0, 4, 5);
        int target = 5;
        System.out.println(countPairs(numbers, target));
    }

    public static long countPairs(List<Integer> numbers, int target) {
        long count = 0;
        for (int j=0; j<numbers.size(); j++) {
            int index=j;
            count += numbers.subList(j+1, numbers.size()).stream().filter(x -> x + numbers.get(index) == target).count();
        }
        return count;
    }
}
