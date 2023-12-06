class Solution {
    public int totalMoney(int n) {
         int weeks = n / 7;
        int days = n % 7;
        int lowest = 28;
        int highest = 28 + 7 * (weeks - 1);
        int total = (lowest + highest) * weeks / 2;

        int monday = weeks + 1;
        for (int i = 0; i < days; i++) {
            total += i + monday;
        }

        return total; 
    }
}