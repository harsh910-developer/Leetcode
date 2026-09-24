class Solution {
    int idx = 0;
    public String decodeString(String s) {
        return decode(s);
    }
    public String decode(String s){
        StringBuilder result = new StringBuilder();
        while(idx < s.length() && s.charAt(idx) != ']'){
            char ch = s.charAt(idx);

            if(Character.isDigit(ch)){
                int k = 0;
                while(idx < s.length() && Character.isDigit(s.charAt(idx))){
                    k = k*10 + (s.charAt(idx) - '0');
                    idx++;
                }
                idx++;
                String inner = decode(s);
                idx++;

                for(int i=0; i<k; i++){
                    result.append(inner);
                }
            }else{
                result.append(ch);
                idx++;
            }
        }
        return result.toString();
    }
}