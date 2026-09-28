class Solution {
    public int largestAltitude(int[] gain) {
        int a = 0;
        int maxA = 0;

        for (int i = 0; i < gain.length; i++) {
            a += gain[i];

            if (a > maxA) {
                maxA = a;
            }
        }
        return maxA;
    }
}