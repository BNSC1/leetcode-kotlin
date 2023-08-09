class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>(){
            @Override
            public Integer get(Object key) {
                if(!containsKey(key))
                    return 0;
                return super.get(key);
            }
        }; //char : index

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
} //TC: O(n), SC: O(n) as hash map is used, where n is the length of the string