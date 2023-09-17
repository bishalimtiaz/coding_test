package important.binary_search;

public class BinarySearch {

    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // End Condition: left > right
        return -1;
    }

    public int lowerBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) left = mid + 1;
            else right = mid;
        }
        return (nums[left] == target) ? left : -1;
    }

    public int upperBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) left = mid;
            else right = mid;

        }
        return (nums[right] == target) ? right : (nums[left] == target) ? left : -1;
    }
}
