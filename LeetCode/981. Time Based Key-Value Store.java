class TimeMap {
    Map<String, List<Data>> map = new HashMap<>() {
        @Override
        public List<Data> get(Object key) {
            if (!containsKey(key)) return new ArrayList<Data>();
            else return super.get(key);
        }
    };

    public TimeMap() {} //SC: O(n), where n is the number of timestamp data

    public void set(String key, String value, int ts) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, ts));
    } //TC: O(1)

    public String get(String key, int ts) {
        List<Data> values = map.get(key);
        String res = "";

        int start = 0;
        int end = values.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (values.get(mid).ts <= ts) {
                res = values.get(mid).value;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    } //TC: O(logn), where n is the number of timestamp in current key list
}
class Data {
    int ts = 0;
    String value = "";

    Data(String value, int ts) {
        this.ts = ts;
        this.value = value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */