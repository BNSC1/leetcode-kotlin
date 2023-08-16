class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        class Helper {
            void backtrack(List<Integer> cur) {
                if (cur.size() == size) {
                    res.add(new ArrayList<>(cur));
                    return;
                }
                for (int i = 0; i < size; i++) {
                    if (cur.contains(nums[i])) continue;
                    cur.add(nums[i]);
                    backtrack(cur);
                    cur.remove(cur.size() - 1);
                }
            }
        }
        new Helper().backtrack(new ArrayList<>());
        return res;
    }
} // TC: O(n*n!), SC: O(n*n!), where n is the length of nums array