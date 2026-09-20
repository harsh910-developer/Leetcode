class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int dsh = 0;
        int left = 0;
        int right = 0;
        for(char ch : moves.toCharArray()){
            
            if(ch == 'L'){
                left++;
            }else if(ch == 'R'){
                right++;
            }else{
                dsh++;
            }
        }
        return Math.abs(right-left) + dsh;
    }
}