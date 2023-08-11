class Solution {
    public boolean canFinish(int numCourses, int[][] prereqs) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visit = new HashSet<>();

        class H {
            boolean dfs(int c) {
                if (preMap.isEmpty()) return true;
                if (visit.contains(c)) return false;

                visit.add(c);
                if (preMap.containsKey(c)) {
                    for (int pre : preMap.get(c)) {
                        if (!dfs(pre)) return false;
                    }
                }
                visit.remove(c);
                if (preMap.get(c) == null) {
                    preMap.put(c, new ArrayList<>());
                } else preMap.get(c).clear();
                return true;
            }
        }

        for (int[] pre : prereqs) {
            List<Integer> list = preMap.get(pre[0]);
            if (list == null) {
                preMap.put(pre[0], new ArrayList<>());
                list = preMap.get(pre[0]);
            }
            list.add(pre[1]);
        }
        for (int c=0;c<numCourses;c++) {
            if (!new H().dfs(c)) return false;
        }
        return true;
    }
} //TC: O(n+e), SC: O(n+e), where n is numCourses and e is the size of prereqs