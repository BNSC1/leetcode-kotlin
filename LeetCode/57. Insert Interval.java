class Solution {
    public int[][] insert(int[][] ins, int[] newI) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < ins.length; i++) {
            int[] in = ins[i];
            if (in[0] > newI[1]) {
                list.add(newI);
                list.addAll(Arrays.asList(Arrays.copyOfRange(ins, i, ins.length)));
                return list.toArray(new int[0][0]);
            } else if (in[1] < newI[0]) {
                list.add(in);
            } else {
                newI[0] = Math.min(newI[0], in[0]);
                newI[1] = Math.max(newI[1], in[1]);
            }
        }
        list.add(newI);
        return list.toArray(new int[0][0]);
    }
} //TC: O(n), SC: O(n)