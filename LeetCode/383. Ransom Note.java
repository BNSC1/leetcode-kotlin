class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int cnt = 0;
            if (map.containsKey(c)) {
                cnt = map.get(c);
            }
            map.put(c, cnt + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
} //TC: O(n), SC: O(n)