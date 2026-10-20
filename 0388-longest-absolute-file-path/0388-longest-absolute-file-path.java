class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int[] lengths = new int[lines.length + 1];
        int maxLen = 0;

        for(String line : lines){
            int depth = line.lastIndexOf("\t") + 1;
            String name = line.substring(depth);
            lengths[depth + 1] = lengths[depth] + name.length() + 1;

            if(name.contains(".")){
                maxLen = Math.max(maxLen, lengths[depth + 1] - 1);
            }
        }
        return maxLen;
    }
}