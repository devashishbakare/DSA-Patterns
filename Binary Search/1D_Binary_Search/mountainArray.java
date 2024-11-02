//problem : https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/description/

//code 1: LIS with binary search

class Solution {

    private List<Integer> getLongestIncreasingSubsequenceLength(
        List<Integer> v
    ) {
        List<Integer> lisLen = new ArrayList<>(
            Collections.nCopies(v.size(), 1)
        );
        List<Integer> lis = new ArrayList<>();
        lis.add(v.get(0));

        for (int i = 1; i < v.size(); i++) {
            int index = lowerBound(lis, v.get(i));

            if (index == lis.size()) {
                lis.add(v.get(i));
            } else {
                // Replace the element at index with v[i]
                lis.set(index, v.get(i));
            }

            lisLen.set(i, lis.size());
        }

        return lisLen;
    }

    private int lowerBound(List<Integer> lis, int target) {
        int left = 0, right = lis.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int minimumMountainRemovals(int[] nums) {
        int N = nums.length;
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) numsList.add(num);

        List<Integer> lisLength = getLongestIncreasingSubsequenceLength(
            numsList
        );

        Collections.reverse(numsList);
        List<Integer> ldsLength = getLongestIncreasingSubsequenceLength(
            numsList
        );
        Collections.reverse(ldsLength);

        int minRemovals = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (lisLength.get(i) > 1 && ldsLength.get(i) > 1) {
                minRemovals = Math.min(
                    minRemovals,
                    N - lisLength.get(i) - ldsLength.get(i) + 1
                );
            }
        }

        return minRemovals;
    }
}

//code 2 : LIS with DP
class Solution {

    public int minimumMountainRemovals(int[] nums) {
        int N = nums.length;

        int[] lisLength = new int[N];
        int[] ldsLength = new int[N];

        Arrays.fill(lisLength, 1);
        Arrays.fill(ldsLength, 1);

        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    lisLength[i] = Math.max(lisLength[i], lisLength[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] > nums[j]) {
                    ldsLength[i] = Math.max(ldsLength[i], ldsLength[j] + 1);
                }
            }
        }

        int minRemovals = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (lisLength[i] > 1 && ldsLength[i] > 1) {
                minRemovals = Math.min(
                    minRemovals,
                    N - lisLength[i] - ldsLength[i] + 1
                );
            }
        }

        return minRemovals;
    }
}