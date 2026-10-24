class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int startA = dateOfYears(arriveAlice);
        int endA = dateOfYears(leaveAlice);
        int startB = dateOfYears(arriveBob);
        int endB = dateOfYears(leaveBob);
        
        int overlapStart = Math.max(startA, startB);
        int overlapEnd = Math.min(endA, endB);

        return Math.max(0, overlapEnd - overlapStart + 1);
    }
    public int dateOfYears(String dateStr){
        int month = Integer.parseInt(dateStr.substring(0, 2));
        int day = Integer.parseInt(dateStr.substring(3, 5));

        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayCount = 0;

        for (int i = 0; i < month - 1; i++) {
            dayCount += daysInMonths[i];
        }
        return dayCount + day;
    }
}