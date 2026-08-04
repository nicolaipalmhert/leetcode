import java.util.Arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int count = 0;
        for (int num : nums1) {
            merged[count] = num;
            count++;
        }
        for (int num : nums2) {
            merged[count] = num;
            count++;
        }
        Arrays.sort(merged);
        int length = merged.length;
        int middle = length/2;
        if (merged.length % 2 == 1) {
            return merged[middle]; 
        } else {
            return (merged[middle - 1] + merged[middle]) / 2.0;
        }


    }
}
