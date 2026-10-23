class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n - 1;
        String ans = "";
        while(left <= right){
            int mid = left + (right - left) / 2;
            int start = index(s, mid);
            if(start != -1){
                ans = s.substring(start, start + mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
    public int index(String s, int len){
        long MOD = 1_000_000_007L;
        long hash = 0;
        long power = 1;
        long base = 26;

        int n = s.length();

        for(int i=0; i<len; i++){
            hash = (hash * base + (s.charAt(i) - 'a')) % MOD;
            if(i < len - 1){
                power = (power * base) % MOD;
            }
        }
        HashMap<Long, List<Integer>> map = new HashMap<>();
        map.computeIfAbsent(hash, k -> new ArrayList<>()).add(0);

        for(int i=len; i<n; i++){
            hash = (hash - (s.charAt(i - len) - 'a') * power % MOD + MOD) % MOD;
            hash = (hash * base + (s.charAt(i) - 'a')) % MOD;

            int start = i - len + 1;
            if(map.containsKey(hash)){
                for(int prev : map.get(hash)){
                    if(s.regionMatches(prev, s, start, len)){
                        return start;
                    }
                }
            }
            map.computeIfAbsent(hash, k -> new ArrayList<>()).add(start);
        }
        return -1;
    }
}