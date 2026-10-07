class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> result = new HashSet<>();
        int left = 0;
        int right = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        backTrack(
            s,
            0,
            left,
            right,
            0,
            new StringBuilder(),
            result
        );

        return new ArrayList<>(result);
    }
    public void backTrack(
        String s,
        int idx,
        int left,
        int right,
        int balance,
        StringBuilder str,
        HashSet<String> result
    ) {
        if (balance < 0) {
            return;
        }
        if (left + right > s.length() - idx) {
            return;
        }
        if (idx == s.length()) {
            if (left == 0 && right == 0 && balance == 0) {
                result.add(str.toString());
            }
            return;
        }
        char ch = s.charAt(idx);

        if (ch == '(') {

            if (left > 0) {
                backTrack(
                    s,
                    idx + 1,
                    left - 1,
                    right,
                    balance,
                    str,
                    result
                );
            }
            str.append(ch);

            backTrack(
                s,
                idx + 1,
                left,
                right,
                balance + 1,
                str,
                result
            );
            str.deleteCharAt(str.length() - 1);
        }
        else if (ch == ')') {

            if (right > 0) {
                backTrack(
                    s,
                    idx + 1,
                    left,
                    right - 1,
                    balance,
                    str,
                    result
                );
            }
            if (balance > 0) {
                str.append(ch);
                backTrack(
                    s,
                    idx + 1,
                    left,
                    right,
                    balance - 1,
                    str,
                    result
                );
                str.deleteCharAt(str.length() - 1);
            }
        }
        else {
            str.append(ch);
            backTrack(
                s,
                idx + 1,
                left,
                right,
                balance,
                str,
                result
            );
            str.deleteCharAt(str.length() - 1);
        }
    }
}
