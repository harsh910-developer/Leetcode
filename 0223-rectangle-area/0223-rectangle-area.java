class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ay2 - ay1) * (ax2 - ax1);
        int area2 = (by2 - by1) * (bx2 - bx1);
        int x5 = Math.max(ax1, bx1);
        int y5 = Math.max(ay1, by1);
        int x6 = Math.min(ax2, bx2);
        int y6 = Math.min(ay2, by2);

        int inter = Math.max(0, x6 - x5) * Math.max(0, y6 - y5);

        return area1 + area2 - inter;

    }
}