/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 *
 * https://leetcode.com/problems/h-index-ii/description/
 *
 * algorithms
 * Medium (35.25%)
 * Total Accepted:    76.9K
 * Total Submissions: 218.2K
 * Testcase Example:  '[0,1,3,5,6]'
 *
 * Given an array of citations sorted in ascending order (each citation is a
 * non-negative integer) of a researcher, write a function to compute the
 * researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: "A scientist has index
 * h if h of his/her N papers have at least h citations each, and the other N −
 * h papers have no more than h citations each."
 * 
 * Example:
 * 
 * 
 * Input: citations = [0,1,3,5,6]
 * Output: 3 
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each
 * of them had 
 * ⁠            received 0, 1, 3, 5, 6 citations respectively. 
 * Since the researcher has 3 papers with at least 3 citations each and the
 * remaining 
 * two with no more than 3 citations each, her h-index is 3.
 * 
 * Note:
 * 
 * If there are several possible values for h, the maximum one is taken as the
 * h-index.
 * 
 * Follow up:
 * 
 * 
 * This is a follow up problem to H-Index, where citations is now guaranteed to
 * be sorted in ascending order.
 * Could you solve it in logarithmic time complexity?
 * 
 * 
 */
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int low = 0, high = citations.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(citations[mid] == citations.length - mid)
                return citations.length - mid;
            else if(citations[mid] >= citations.length - mid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return citations.length - low;
    }
}

