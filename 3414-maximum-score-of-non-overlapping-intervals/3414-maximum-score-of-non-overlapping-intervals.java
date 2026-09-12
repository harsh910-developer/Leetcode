import java.util.*;

class Solution {
    List<List<Integer>> a;
    int n;
    long[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();
        a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(Arrays.asList(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            ));
        }

        a.sort(Comparator.comparingInt(x -> x.get(0)));

        // dp[i][k] = maximum score using i..n-1 with k choices left
        dp = new long[n + 1][5];

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {
                int j = next(i);

                dp[i][k] = Math.max(
                    dp[i + 1][k],
                    a.get(i).get(2) + dp[j][k - 1]
                );
            }
        }

        List<Integer> ans = new ArrayList<>();
        build(0, 4, ans);

        Collections.sort(ans);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    // First interval whose left > current right
    int next(int i) {
        int target = a.get(i).get(1);

        int lo = i + 1, hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (a.get(mid).get(0) > target)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    void build(int i, int k, List<Integer> ans) {
        if (i >= n || k == 0)
            return;

        int j = next(i);
        long take = a.get(i).get(2) + dp[j][k - 1];
        long skip = dp[i + 1][k];

        if (take > skip) {
            ans.add(a.get(i).get(3));
            build(j, k - 1, ans);
        } else if (take < skip) {
            build(i + 1, k, ans);
        } else {
            // Same score: need lexicographically smaller answer.
            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();

            x.add(a.get(i).get(3));
            collect(j, k - 1, x);

            collect(i + 1, k, y);

            Collections.sort(x);
            Collections.sort(y);

            if (smaller(x, y))
                ans.addAll(x);
            else
                ans.addAll(y);
        }
    }

    void collect(int i, int k, List<Integer> ans) {
        if (i >= n || k == 0)
            return;

        int j = next(i);

        long take = a.get(i).get(2) + dp[j][k - 1];
        long skip = dp[i + 1][k];

        if (take >= skip) {
            ans.add(a.get(i).get(3));
            collect(j, k - 1, ans);
        } else {
            collect(i + 1, k, ans);
        }
    }

    boolean smaller(List<Integer> x, List<Integer> y) {
        for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
            if (!x.get(i).equals(y.get(i)))
                return x.get(i) < y.get(i);
        }
        return x.size() < y.size();
    }
}
