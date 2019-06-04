import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int[] newArray = new int[l1 + l2];
        // indexes of nums1 and nums2
        int i = 0, j = 0;
        for (int index = 0; index < newArray.length; index++) {
            if (i == nums1.length) {
                newArray[index] = nums2[j];
                j++;
            } else if (j == nums2.length) {
                newArray[index] = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                newArray[index] = nums1[i];
                i++;
            } else if (nums1[i] >= nums2[j]) {
                newArray[index] = nums2[j];
                j++;
            }
        }
        if (newArray.length % 2 != 0)
            return newArray[newArray.length / 2];
        else
            return (newArray[newArray.length / 2 - 1] + newArray[newArray.length / 2]) / 2.0;
    }
}
