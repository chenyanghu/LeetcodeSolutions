/*
 * @lc app=leetcode id=352 lang=java
 *
 * [352] Data Stream as Disjoint Intervals
 */
class SummaryRanges {

    TreeMap<Integer, Integer> tree;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        // all intevals are stored as [key, value]
        Integer lowerKey = tree.lowerKey(val);
        Integer higherKey = tree.higherKey(val);

        Integer lowerValue = lowerKey == null ? lowerKey : tree.get(lowerKey);
        Integer higherValue = higherKey == null ? higherKey : tree.get(higherKey);

        // case 1: new element is 1 bigger than lowerValue and 1 smaller than higherKey
        // [1, 3], 4, [5, 7] --> [1, 7];
        if (lowerKey != null && higherKey != null && lowerValue + 1 == val && val == higherKey - 1) {
            tree.put(lowerKey, higherValue);
            tree.remove(higherKey);
        }
        // case 2: new element is between lowerKey to lowverValue
        else if (lowerKey != null && lowerValue + 1 >= val) {
            tree.put(lowerKey, Math.max(lowerValue, val));
        }
        // case 3: new element is between lowerValue to higherKey
        // [1, 3], 5, [6, 8] --> [1, 3], [5, 8]
        else if (higherKey != null && val + 1 == higherKey) {
            tree.put(val, higherValue);
            tree.remove(higherKey);
        }
        // case 4:
        else {
            tree.putIfAbsent(val, val);
        }
    }

    public int[][] getIntervals() {
        return tree.entrySet().stream().map(e -> new int[] { e.getKey(), e.getValue() }).toArray(int[][]::new);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges(); obj.addNum(val); int[][] param_2 =
 * obj.getIntervals();
 */
