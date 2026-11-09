class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> busyServer = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        TreeSet<Integer> availableServer = new TreeSet<>();

        for(int i=0; i<k; i++){
            availableServer.add(i);
        }
        int[] requestCount = new int[k];
        int maxRequest = 0;
        for(int i=0; i<arrival.length; i++){
            int currTime = arrival[i];

            while(!busyServer.isEmpty() && busyServer.peek()[0] <= currTime){
                int[] freed = busyServer.poll();
                availableServer.add(freed[1]);
            }
            if(availableServer.isEmpty()){
                continue;
            }
            Integer targetServer = availableServer.ceiling(i % k);
            if(targetServer == null){
                targetServer = availableServer.first();
            }
            availableServer.remove(targetServer);
            busyServer.offer(new int[]{currTime+load[i], targetServer});
            requestCount[targetServer]++;
            maxRequest = Math.max(maxRequest, requestCount[targetServer]);
        }
        List<Integer> busiest = new ArrayList<>();
        for(int i=0; i<k; i++){
            if(requestCount[i] == maxRequest){
                busiest.add(i);
            }
        }
        return busiest;   
    }
}