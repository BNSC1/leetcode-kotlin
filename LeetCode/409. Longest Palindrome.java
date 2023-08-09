class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                res += 2;
            } else set.add(c);
        }
        if (!set.isEmpty()) res++;
        return res;
    }
} //TC: O(n), SC: O(n), where n is the length of s