import java.util.*;

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int LOG = 32 - Integer.numberOfLeadingZeros(n);
        int[][] up = new int[LOG][n];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];

        // Iterative DFS to avoid stack overflow.
        int[] stackNode = new int[2 * n + 5];
        int[] stackParent = new int[2 * n + 5];
        int[] stackState = new int[2 * n + 5];

        int top = 0, timer = 0;
        stackNode[top] = 0;
        stackParent[top] = -1;
        stackState[top++] = 0;

        while (top > 0) {
            --top;
            int u = stackNode[top];
            int p = stackParent[top];
            int state = stackState[top];

            if (state == 0) {
                tin[u] = timer++;
                up[0][u] = (p == -1) ? u : p;

                // Exit event.
                stackNode[top] = u;
                stackParent[top] = p;
                stackState[top++] = 1;

                for (int v : graph[u]) {
                    if (v == p) continue;

                    depth[v] = depth[u] + 1;
                    stackNode[top] = v;
                    stackParent[top] = u;
                    stackState[top++] = 0;
                }
            } else {
                tout[u] = timer - 1;
            }
        }

        // Binary lifting table for LCA.
        for (int k = 1; k < LOG; k++) {
            for (int u = 0; u < n; u++) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }
        }

        Fenwick bit = new Fenwick(n);
        int[] mask = new int[n];

        for (int u = 0; u < n; u++) {
            mask[u] = 1 << (s.charAt(u) - 'a');
            bit.rangeXor(tin[u], tout[u], mask[u]);
        }

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                int newMask = 1 << (parts[2].charAt(0) - 'a');

                int delta = mask[u] ^ newMask;
                bit.rangeXor(tin[u], tout[u], delta);
                mask[u] = newMask;

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int w = lca(u, v, depth, up, LOG);

                int pathMask = bit.pointQuery(tin[u])
                             ^ bit.pointQuery(tin[v])
                             ^ mask[w];

                // At most one character may have odd frequency.
                answer.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return answer;
    }

    private int lca(int u, int v, int[] depth, int[][] up, int LOG) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }

    static class Fenwick {
        int n;
        int[] tree;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        private void update(int index, int value) {
            index++;

            while (index <= n) {
                tree[index] ^= value;
                index += index & -index;
            }
        }

        private int prefixXor(int index) {
            index++;
            int result = 0;

            while (index > 0) {
                result ^= tree[index];
                index -= index & -index;
            }

            return result;
        }

        void rangeXor(int left, int right, int value) {
            update(left, value);

            if (right + 1 < n) {
                update(right + 1, value);
            }
        }

        int pointQuery(int index) {
            return prefixXor(index);
        }
    }
}