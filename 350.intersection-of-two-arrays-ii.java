class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums1){
            if(!map.containsKey(n))
                map.put(n, 1);
            else
                map.put(n, map.get(n) + 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int n : nums2){
            if(map.containsKey(n) && map.get(n) > 0){
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for(int n : list){
            res[i++] = n;
        }
        return res;
    }
}

