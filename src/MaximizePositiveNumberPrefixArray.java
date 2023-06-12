import java.util.Arrays;
import java.util.Collections;

/**
 * <a href="https://leetcode.com/discuss/interview-question/2114094/What-would-be-the-solution-to-this/1422998">...</a>
 */

public class MaximizePositiveNumberPrefixArray {

    public static int numberOfPositiveElements(int[] arr) {

        Integer[] list = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(list, Collections.reverseOrder());

        int count = 0;
        int sum = 0;

        for (Integer integer : list) {
            sum += integer;
            if (sum > 0) count++;
        }

        return count;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{-6,3,4,-10};
        System.out.println(numberOfPositiveElements(arr));

    }
}
