class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<words.length; i++){
            String word = words[i];
            int sum = 0;
            for(int j=0; j<word.length(); j++){
                char ch = word.charAt(j);

                int idx = ch - 'a';
                sum += weights[idx];
            }
            int value = sum % 26;
            char r = (char) ('z' - value);
            sb.append(r);
        }
        return sb.toString();
    }
}