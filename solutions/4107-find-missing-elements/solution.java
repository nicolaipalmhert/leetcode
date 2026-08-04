class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> missing = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int left = nums[i];
            int right = nums[i+1];

            if ((right - left) > 1) {
                int missingNum = left + 1;
                while (missingNum < right) {
                    missing.add(missingNum);
                    missingNum++;
                }
            }
        }
        return missing;
    }
}
