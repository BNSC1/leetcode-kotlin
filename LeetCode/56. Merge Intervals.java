class Solution {
    public int[][] merge(int[][] ints) {
        Arrays.sort(ints, Comparator.comparingInt(o -> o[0]));
        int size = ints.length;
        LinkedList<int[]> list = new LinkedList<>();
        list.add(ints[0]);
        for (int i = 1; i < size; i++) {
            int[] last = list.peekLast();
            int[] cur = ints[i];
            if (last[1] >= cur[0]) {
                int newStart = Math.min(last[0], cur[0]);
                int newEnd = Math.max(last[1], cur[1]);
                list.pollLast();
                list.add(new int[]{newStart, newEnd});
            } else {
                list.add(cur);
            }
        }
        return list.toArray(new int[0][0]);
    }
} //TC: O(nlogn), SC: O(n), where n is the length of ints