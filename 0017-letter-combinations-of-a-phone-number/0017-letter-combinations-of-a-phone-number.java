class Solution {
    String[] mapping = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        backTrack(digits, 0, "", result);
        return result;
    }
    public void backTrack(String digits, int index, String current, List<String> result){
        if(index == digits.length()){
            result.add(current);
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];

        for(char ch : letters.toCharArray()){
            backTrack(digits, index+1, current + ch, result);
        }
    }
}