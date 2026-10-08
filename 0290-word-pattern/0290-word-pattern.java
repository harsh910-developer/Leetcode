class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> revMap = new HashMap<>();
        String[] words = s.trim().split("\\s+");
        if(words.length != pattern.length()){
            return false;
        }
        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(map.containsKey(ch) && !map.get(ch).equals(word)){
                return false;
            }
            if(revMap.containsKey(word) && revMap.get(word) != ch){
                return false;
            }
            map.put(ch, word);
            revMap.put(word, ch);
        }
        return true;
    }
}