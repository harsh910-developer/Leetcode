class Solution {
    private String s;
    private int idx;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        idx = 0;

        Set<String> set = parseExpression();
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
    private Set<String> parseExpression(){
        Set<String> result = new HashSet<>();

        while(true){
            result.addAll(parseTerm());
            if(idx < s.length() && s.charAt(idx) == ','){
                idx++;
            }else{
                break;
            }
        }
        return result;
    }
    private Set<String> parseTerm(){
        Set<String> result = new HashSet<>();
        result.add("");

        while(idx < s.length() && s.charAt(idx) != '}' && s.charAt(idx) != ','){
            Set<String> next = parseFactor();
            Set<String> temp = new HashSet<>();

            for(String a : result){
                for(String b : next){
                    temp.add(a + b);
                }
            }
            result = temp;
        }
        return result;
    }
    private Set<String> parseFactor(){
        Set<String> result = new HashSet<>();

        if(s.charAt(idx) == '{'){
            idx++;
            result = parseExpression();
            idx++;
        }else{
            result.add(String.valueOf(s.charAt(idx)));
            idx++;
        }
        return result;
    }
}