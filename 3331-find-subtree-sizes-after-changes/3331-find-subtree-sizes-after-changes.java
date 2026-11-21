class Solution {
    private List<List<Integer>> adj;
    private List<List<Integer>> newAdj;
    private int[] newParent;
    private int[] lastSeen;
    private int[] ans;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.newParent = Arrays.copyOf(parent, n);
        this.lastSeen = new int[26];
        Arrays.fill(this.lastSeen, -1);

        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        dfsReparent(0);
        newAdj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            newAdj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            newAdj.get(newParent[i]).add(i);
        }
        ans = new int[n];
        dfsSize(0);
        return ans;
    }

    public void dfsReparent(int u) {
        int charAtIdx = s.charAt(u) - 'a';
        int prevAncester = lastSeen[charAtIdx];

        if (prevAncester != -1) {
            newParent[u] = prevAncester;
        }
        lastSeen[charAtIdx] = u;
        for (int v : adj.get(u)) {
            dfsReparent(v);
        }
        lastSeen[charAtIdx] = prevAncester;
    }

    public int dfsSize(int u) {
        int size = 1;
        for (int v : newAdj.get(u)) {
            size += dfsSize(v);
        }
        ans[u] = size;
        return size;
    }
}