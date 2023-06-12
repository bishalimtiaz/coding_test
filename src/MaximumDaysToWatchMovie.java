import java.util.Arrays;


/**
 * A friend of Alex has gifted a movie collection, and Alex is excited to watch them all as quickly as possible.
 * The duration of the movies is given in array durations[n], where n is the number of movies,
 * and each movie duration lies between 1.01 and 3.00 units of time (up to two decimal places).
 * Every day, Alex wants to spend no more than 3.00 units of time watching the movies but also wants to complete the movies in the least number of days possible.
 * Alex does not leave a movie in between. That is, if Alex has picked up a movie, Alex watches the complete movie on the same day.
 * Find the minimum number of days needed to watch all the movies.
 * <p>
 * One test case  : durations = [1.9, 1.04, 1.25, 2.5, 1.75] , Answer : 3
 */

public class MaximumDaysToWatchMovie {

    public static int maxDays(float[] movies) {

        Arrays.sort(movies);


        int left = 0;
        int right = movies.length - 1;

        int days = 0;

        while (left < right) {

            if (movies[right] > 1.99f) {
                right--;
            } else if ((movies[right] + movies[left]) <= 3f) {
                left++;
                right--;

            } else {
                right--;
            }
            days++;

        }
        return days;
    }

    public static void main(String[] args) {
        float[] movies = new float[]{1.90f, 1.04f, 1.25f, 2.5f, 1.75f};

        System.out.println(maxDays(movies));
    }
}
