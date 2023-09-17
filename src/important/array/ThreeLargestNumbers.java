package important.array;

/**
 * Write a function that takes in an array of at least three integers and, without sorting the input array, returns a sorted array of the three largest integers in the input array.
 * The function should return duplicate integers if necessary; for example, it should return [10, 10, 12] for an input array of [10, 5, 9, 10, 12].
 * <p>
 * Sample Input
 * array = [141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 71
 * Sample Output
 * [18, 141, 541]
 **/
public class ThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        // Write your code here.

        for (int num : array) {

            if (num > third) {
                first = second;
                second = third;
                third = num;
            } else if (num > second) {
                first = second;
                second = num;
            } else if (num > first) {
                first = num;
            }
        }
        return new int[]{first, second, third};
    }
}
