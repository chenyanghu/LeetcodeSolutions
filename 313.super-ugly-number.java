import java.util.PriorityQueue;
/*
 * @lc app=leetcode id=313 lang=java
 *
 * [313] Super Ugly Number
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        //1 is the first supernum
        if(n == 1)
            return 1;
        //All int in pq is sorted.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i : primes)
            pq.offer(i);
        //Each loop generate i+1th supernum
        for(int i = 1; i < n - 1; i++){
            int cur = pq.poll();
            for(int x : primes){
                long mult = (long)cur * (long)x;
                if(mult < Integer.MAX_VALUE)
                    pq.offer((int)mult);
            }
            while(pq.peek() == cur)
                pq.poll();
        }
        return pq.poll();
    }
}

