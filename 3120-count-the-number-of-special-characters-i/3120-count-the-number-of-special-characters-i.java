class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] upper = new boolean[26];
        boolean[] lower = new boolean[26];
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)){
                upper[ch - 'A'] = true;
            }else if(Character.isLowerCase(ch)){
                lower[ch - 'a'] = true;
            }
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(upper[i] && lower[i]){
                count++;
            }
        }
        return count;
    }
}