class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = (x1 > xCenter) ? x1 : (x2 < xCenter) ? x2 : xCenter; 
        int closestY = (y1 > yCenter) ? y1 : (y2 < yCenter) ? y2 : yCenter;

        int dx = xCenter - closestX;
        int dy = yCenter - closestY;

        int distance = (dx * dx) + (dy * dy);

        return (distance <= (radius * radius));
    }
}