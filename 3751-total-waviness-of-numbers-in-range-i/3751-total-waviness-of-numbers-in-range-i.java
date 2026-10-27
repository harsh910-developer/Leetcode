class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for (int i = num1; i <= num2; i++) {
            total += getWaviness(i);
        }
        return total;
    }

    public int getWaviness(int num) {
        String s = String.valueOf(num);
        int count = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);

            if ((curr < prev && curr < next) || (curr > prev && curr > next)) {
                count++;
            }
        }
        return count;
    }
}