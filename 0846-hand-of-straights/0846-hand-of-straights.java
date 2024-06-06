class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        // TreeMap to store card counts in sorted order
        TreeMap<Integer, Integer> cardMap = new TreeMap<>();
        for (int card : hand) {
            cardMap.put(card, cardMap.getOrDefault(card, 0) + 1);
        }

        // Iterate over the sorted keys of cardMap
        for (int card : cardMap.keySet()) {
            int cnt = cardMap.get(card);
            if (cnt > 0) {
                // Try to form groups starting from the current card
                for (int i = 0; i < groupSize; i++) {
                    if (cardMap.getOrDefault(card + i, 0) < cnt) {
                        return false;
                    }
                    // Update the count safely
                    cardMap.put(card + i, cardMap.get(card + i) - cnt);
                }
            }
        }
        return true;
    }
}
