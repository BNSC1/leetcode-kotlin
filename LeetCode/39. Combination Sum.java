class Solution {
    public List<List<Integer>> combinationSum(int[] cands, int target) {
        List<List<Integer>> res = new ArrayList<>();
        class Helper {
            void backtrack(int i, List<Integer> cur, int diff) {
                if (diff == 0) res.add(new ArrayList<>(cur));
                if (i >= cands.length || diff <= 0) return;
                cur.add(cands[i]);
                backtrack(i, cur, diff - cands[i]);
                cur.remove(cur.size() - 1);
                backtrack(i + 1, cur, diff);
            }
        }
        new Helper().backtrack(0, new ArrayList<>(), target);
        return res;
    }
} //TC: O(N^(M/T + 1)), SC: O(T/M), where T is the target value, N is the number of candidates, M is the smallest candidate among all the given integers