class MinStack {
    LinkedList<Node> st = new LinkedList<>();

    public MinStack() {} //SC: O(count of elements)
    
    public void push(int val) {
        if (!st.isEmpty()) {
            st.push(new Node(val, st.peek().minVal));
        } else {
            st.push(new Node(val, Integer.MAX_VALUE));
        }
    } //TC: O(1)
    
    public void pop() {
        st.poll();
    } //TC: O(1)
    
    public int top() {
        return st.peek().val;
    } //TC: O(1)
    
    public int getMin() {
        return st.peek().minVal;
    } //TC: O(1)
}
class Node {
    int minVal = Integer.MAX_VALUE;
    int val = 0;
    Node(int val, int lastMin) {
        this.val = val;
        this.minVal = Math.min(lastMin, this.val);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */