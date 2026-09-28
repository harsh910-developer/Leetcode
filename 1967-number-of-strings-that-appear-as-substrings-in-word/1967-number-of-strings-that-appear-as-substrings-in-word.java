class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int total = 0;
        for(String str : patterns){
            if(word.contains(str)){
                total++;
            }
        }
        return total;
    }
}