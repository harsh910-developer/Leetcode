class Solution {
    public boolean checkRecord(String s) {
        int l = 0;
        int ab = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'A'){
                ab++;
                l = 0;
            }else if(ch == 'L'){
                l++;
                if(l >= 3){
                    return false;
                }
            }else{
                l = 0;
            }
            if(ab >= 2){
                return false;
            }
        }
        return true;
    }
}