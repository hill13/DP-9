// Time complexity: O(n log n)
// Space Complexity: O(n)
// Approach: 
// Traverse the input array and maintain a list (arr) to store the smallest possible tail of all increasing subsequences.
// If current element is greater than the last element in arr, append it; otherwise, binary search to replace the correct position.
// Length of arr gives the length of the Longest Increasing Subsequence (LIS).

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int le = 1;

        for (int i = 1; i < n; i++) {
            if (arr[le - 1] < nums[i]) {
                arr[le] = nums[i];
                le++;
            } else {
                // What Idx to be replaced
                int bsIdx = binarySearch(arr, 0, le, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return le;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}