class Solution {
    private int n, k;
    private int[] nums;
    private Node[] tree;

    static class Node {
        int product;
        int[] cnt;

        Node(int k) {
            cnt = new int[k];
        }
    }

    private Node leaf(int value) {
        Node res = new Node(k);
        int v = value % k;
        res.product = v;
        res.cnt[v] = 1;
        return res;
    }

    private Node merge(Node left, Node right) {
        Node res = new Node(k);

        res.product = (int) ((long) left.product * right.product % k);

        for (int x = 0; x < k; x++) {
            res.cnt[x] += left.cnt[x];
        }

        for (int x = 0; x < k; x++) {
            if (right.cnt[x] == 0) continue;

            int rem = (int) ((long) left.product * x % k);
            res.cnt[rem] += right.cnt[x];
        }

        return res;
    }

    private void build(int p, int l, int r) {
        if (l == r) {
            tree[p] = leaf(nums[l]);
            return;
        }

        int mid = (l + r) >>> 1;

        build(p << 1, l, mid);
        build(p << 1 | 1, mid + 1, r);

        tree[p] = merge(tree[p << 1], tree[p << 1 | 1]);
    }

    private void update(int p, int l, int r, int idx, int value) {
        if (l == r) {
            tree[p] = leaf(value);
            return;
        }

        int mid = (l + r) >>> 1;

        if (idx <= mid) {
            update(p << 1, l, mid, idx, value);
        } else {
            update(p << 1 | 1, mid + 1, r, idx, value);
        }

        tree[p] = merge(tree[p << 1], tree[p << 1 | 1]);
    }

    private Node query(int p, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[p];
        }

        int mid = (l + r) >>> 1;

        if (qr <= mid) {
            return query(p << 1, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(p << 1 | 1, mid + 1, r, ql, qr);
        }

        Node left = query(p << 1, l, mid, ql, qr);
        Node right = query(p << 1 | 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.nums = nums;
        this.n = nums.length;
        this.k = k;

        tree = new Node[4 * n];
        build(1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            nums[index] = value;
            update(1, 0, n - 1, index, value);

            Node res = query(1, 0, n - 1, start, n - 1);
            ans[i] = res.cnt[x];
        }

        return ans;
    }
}
