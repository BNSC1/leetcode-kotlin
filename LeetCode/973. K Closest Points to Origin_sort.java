class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][0];
        List<Pair<Integer, Integer>> list = new ArrayList<>(); //index : distance

        for (int i = 0; i < points.length; i++) {
            int[] pt = points[i];
            int dst = pt[0] * pt[0] + pt[1] * pt[1];
            list.add(new Pair<Integer,Integer> (i, dst));
        }
        list.sort(Comparator.comparing(Pair::getValue));
        for (int i = 0; i < k; i++) {
            res[i] = points[list.get(i).getKey()];
        }
        return res;
    }
} //TC: O(nlogn), SC: O(n) as sorting and list is involved