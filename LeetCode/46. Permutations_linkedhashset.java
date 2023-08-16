class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        class Helper {
            void backtrack(Set<Integer> cur) {
                if (cur.size() == size) {
                    res.add(new ArrayList<>(cur));
                    return;
                }
                for (int i = 0; i < size; i++) {
                    if (cur.contains(nums[i])) continue;
                    cur.add(nums[i]);
                    backtrack(cur);
                    cur.remove(nums[i]);
                }
            }
        }
        new Helper().backtrack(new LinkedHashSet<>());
        return res;
    }
} // TC: O(n!), SC: O(n*n!), where n is the length of nums array