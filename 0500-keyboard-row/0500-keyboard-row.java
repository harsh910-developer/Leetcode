class Solution {
    String row1 = "qwertyuiop";
    String row2 = "asdfghjkl";
    String row3 = "zxcvbnm";
    public String[] findWords(String[] words) {

        List<String> list = new ArrayList<>();
        for(String word : words){
            String w = word.toLowerCase();
            String row;

            char first = w.charAt(0);
            if (row1.indexOf(first) != -1) {
                row = row1;
            } else if (row2.indexOf(first) != -1) {
                row = row2;
            } else {
                row = row3;
            }
            boolean sameRow = true;
            for(int i=0; i<w.length(); i++){
                if(row.indexOf(w.charAt(i)) == -1){
                    sameRow = false;
                    break;
                }
            }
            if(sameRow){
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
}