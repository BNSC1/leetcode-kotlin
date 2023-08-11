class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][0];
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparing(Pair::getValue)); //index : distance

        for (int i = 0; i < points.length; i++) {
            int[] pt = points[i];
            int dst = pt[0] * pt[0] + pt[1] * pt[1];
            heap.offer(new Pair<> (i, dst));
        }
        for (int i = 0; i < k; i++) {
            res[i] = points[heap.poll().getKey()];
        }
        return res;
    }
} //TC: O(nlogn), SC: O(n) as priority queue is used for sorting