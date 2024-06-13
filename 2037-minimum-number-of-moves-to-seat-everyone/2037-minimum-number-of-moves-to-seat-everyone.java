class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        
        // Sort the students array
        Arrays.sort(students);
        
        // Initialize the count of moves to 0
        int count = 0;
        
        // Iterate through the sorted arrays
        for (int i = 0; i < seats.length; i++) {
            // Calculate the absolute difference between the seat and student positions
            count += Math.abs(seats[i] - students[i]);
        }
        
        // Return the total count of moves
        return count;
    }
}