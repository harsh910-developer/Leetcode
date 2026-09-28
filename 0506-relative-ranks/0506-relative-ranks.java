class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> score[b] - score[a]
        );
        String[] result = new String[score.length];
        for(int i=0; i<score.length; i++){
            pq.add(i);
        }
        int rank = 1;
        while(!pq.isEmpty()){
            int idx = pq.poll();
            if(rank == 1){
                result[idx] = "Gold Medal";
            }else if(rank == 2){
                result[idx] = "Silver Medal";
            }else if(rank == 3){
                result[idx] = "Bronze Medal";
            }else{
                result[idx] = String.valueOf(rank); 
            }
            rank++;
        }
        return result;

    }
}