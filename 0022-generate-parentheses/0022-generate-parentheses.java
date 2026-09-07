class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list, "", 0, 0, n); 
        return list;
    }
    public void backTrack(List<String> list, String s, int open, int close, int max){
        if(s.length() == max*2){
            list.add(s);
            return;
        }
        if(open < max){
            backTrack(list, s+"(", open+1, close, max);
        }
        if(open > close){
            backTrack(list, s+")", open, close+1, max);
        }
    }

}