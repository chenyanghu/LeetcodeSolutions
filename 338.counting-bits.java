class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for(int i = 1; i <= num; i++)
            //DP:
            //1111 >> 1 --> 111 = 3 + (1111 & 1) = 4
            result[i] = result[i >> 1] + (i & 1);
        return result;
    }
}

