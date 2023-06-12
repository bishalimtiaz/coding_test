/**
 * There are m jobs to schedule on n processors. A schedule is balanced if the difference between the number of jobs scheduled on any two neighboring processors does not exceed 1.
 * The kth processor is the most efficient, and thus, the maximum number of jobs should be scheduled on that processor. Find the maximum number of jobs that can be scheduled on the kth processor, such that the overall schedule remains balanced.
 * <p>
 * Note: Each processor must have at least one job scheduled.
 * Example
 * Consider n = 5, m = 11, k= 3.
 * Consider the following job schedules:
 * <p>
 * Schedule           Is Blanced    Jobs Scheduled on the kth processor.
 * [1, 2, 3, 4, 1]      no                   --
 * [1, 2, 3, 3, 2]      yes                  3
 * [2, 2, 2, 2, 3]      yes                  2
 * [2, 2, 3, 2, 2]      yes                  3
 * [1, 1, 7, 1, 1]      no                   --
 * [4, 3, 2, 1, 1]      yes                  2
 * <p>
 * In each schedule, there are 11 jobs across 5 processors.
 * kassumes 1-based indexing.
 * The 1st schedule is not balanced because the 5th processor has 1 job scheduled, while the 4th processor has 4 jobs scheduled, their difference is 3, which exceeds 1.
 * The 5th schedule is not balanced because the difference between the 2nd and 3rd and between 3rd and 4th processors is more than 1.
 * Amongst all balanced schedules, the maximum number of jobs that can be scheduled on the 3rd processor is 3. So, the answer is 3.
 * <p>
 * Function Description
 * Complete the function getMaximumJobs in the editor below.
 * getMaximumjobs has the following parameters:
 * int n: the number of processors int m: the number of jobs
 * int k: the 1-based index of the most efficient processor
 * Returns
 * int: the maximum number of jobs that can be scheduled on the kth processor maintaining a balanced schedule
 * <p>
 * Constraints
 * • 1 ≤ n≤ 10^5
 * • n≤m≤10^9
 * • 1 <k<n
 */

public class JobScheduling {

    public static int getMaximumJobs(int n, int m, int k) {

        k--;                                // Change k to zero based index instead of one based index
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = 1; // Fill the array with 1's first
        int sum = n, maxjob = 1;                 // With all 1's, the sum is n and maxjob is 1

        while (sum <= m) {
            // Increase the kth item by 1; this increased value is now maxjob
            arr[k]++;
            maxjob = arr[k];
            // Make sure difference between elements (on left of kth element) is 1 or less (for balanced schedule)
            // If the difference is more than 1, increase element so that difference is 1
            for (int i = k - 1; i >= 0; i--)
                if ((arr[i + 1] - arr[i]) > 1) arr[i]++;
            // Do same thing for elements to the right of kth element
            for (int i = k + 1; i < n; i++)
                if ((arr[i - 1] - arr[i]) > 1) arr[i]++;

            // Find the new sum of all elements again
            sum = 0;
            for (int i = 0; i < n; i++) sum += arr[i];
        }
        // When we reach here, the sum of the elements is > m, so maxjob is one value too high
        // decrement maxjob and return it
        return maxjob - 1;

    }

    public static void main(String[] args) {
        int n = 5; // number of processor
        int m = 11; // number of jobs
        int k = 5;

        System.out.println(getMaximumJobs(n, m, k));

    }

}
