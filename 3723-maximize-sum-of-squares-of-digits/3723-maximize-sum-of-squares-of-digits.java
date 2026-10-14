class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9*num || sum < 1){
            return "";
        }

        StringBuilder str = new StringBuilder();

        for(int i=0; i<num; i++){
            int digit = Math.min(9, sum);
            str.append(digit);
            sum -= digit;
        }
        return str.toString();

    }
}