//Key: To find how many idles do we need
//Eg: 3A3B2C1D n = 3  -->  AB??AB??AB -->10

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char c : tasks){
            counter[c - 'A']++;
            if(max == counter[c - 'A'])
                maxCount++;
            else if(max < counter[c - 'A']){
                max = counter[c - 'A'];
                maxCount = 1;
            }
        }        

        int partCount = max - 1;//Parts between most frequent task
        int partLength = n - (maxCount - 1);//Length of every part
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;//# of task without the most frequency
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}

