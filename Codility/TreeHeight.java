// No Kotlin version on Codility? Really?

class Solution {
    int res = -1; //-1 is the tree is empty.
    public int solution(Tree T) {
        iterate(T, res);
        return res;
    }

    public void iterate(Tree T, int cnt) { //recursive function to count the height of that branch.
        if (T != null) { //stop the resursive function if the this node is null.
            iterate(T.l, cnt+1);
            iterate(T.r, cnt+1);
        }
        res = Math.max(res, cnt);
    }
}
