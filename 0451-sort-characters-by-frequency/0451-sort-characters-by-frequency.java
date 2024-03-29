class Solution {
    public String frequencySort(String s) {
       Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        // Declare a max heap for sorting the map values based on frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        maxHeap.addAll(charFreq.entrySet());

        // Start storing the chars in ans frequency-wise
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char ch = entry.getKey();
            int freq = entry.getValue();

            // Append the current char (freq) times
            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }

        return result.toString(); 
    }
}
