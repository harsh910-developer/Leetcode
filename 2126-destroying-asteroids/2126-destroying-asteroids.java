class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long planetMass = mass;
        for(int a : asteroids){
            if(planetMass < a){
                return false;
            }
            planetMass += a;
        }
        return true;
    }
}