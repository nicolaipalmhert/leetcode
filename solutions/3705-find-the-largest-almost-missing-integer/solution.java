class Solution {
    public int largestInteger(int[] nums, int k) {

        HashMap<Integer, Integer> windowCount = new HashMap<>();
        HashMap<Integer, Integer> occurrences = new HashMap<>();

        // erstes Window aufbauen
        for (int i = 0; i < k; i++) {
            windowCount.put(
                nums[i],
                windowCount.getOrDefault(nums[i], 0) + 1
            );
        }

        // erstes Window in occurrences eintragen
        for (int key : windowCount.keySet()) {
            occurrences.put(
                key,
                occurrences.getOrDefault(key, 0) + 1
            );
        }

        // Sliding Window
        for (int right = k; right < nums.length; right++) {

            int left = nums[right - k];

            // linkes Element entfernen
            if (windowCount.get(left) == 1) {
                windowCount.remove(left);
            } else {
                windowCount.put(
                    left,
                    windowCount.get(left) - 1
                );
            }

            // rechtes Element hinzufügen
            windowCount.put(
                nums[right],
                windowCount.getOrDefault(nums[right], 0) + 1
            );

            // alle Werte im aktuellen Window zählen
            for (int key : windowCount.keySet()) {
                occurrences.put(
                    key,
                    occurrences.getOrDefault(key, 0) + 1
                );
            }
        }

        // größten Wert finden, der nur in einem Window vorkam
        int biggest = -1;

        for (int key : occurrences.keySet()) {
            if (occurrences.get(key) == 1) {
                biggest = Math.max(biggest, key);
            }
        }

        return biggest;
    }
}
