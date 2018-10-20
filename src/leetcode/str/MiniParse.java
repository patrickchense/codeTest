package leetcode.str;

import java.util.ArrayList;
import java.util.List;

/*
leetcode 385
https://leetcode.com/problems/mini-parser/description/

solution:
@DFS
dfs each NestedInteger when meet [
return meet ]
ignore ,
use global index i

 */
public class MiniParse {

    class NestedInteger {
        int val;
        List<NestedInteger> list = new ArrayList<>();

        public NestedInteger() {
        }

        public NestedInteger(int val) {
            this.val = val;
        }

        public void add(NestedInteger n) {
            list.add(n);
        }
    }

    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[')
            return new NestedInteger(Integer.parseInt(s));

        return dfs(s.toCharArray());
    }

    int i = 1;

    public NestedInteger dfs(char[] ca) {
        NestedInteger res = new NestedInteger();

        while (i < ca.length) {
            if (ca[i] == ',') {
                i++;
            } else if (ca[i] == '[') {
                i++;
                res.add(dfs(ca));
            } else if (ca[i] == ']') {
                i++;
                break;
            } else {
                int cur = 0;
                boolean pos = true;
                if (ca[i] == '-') {
                    pos = false;
                    i++;
                }

                while (i < ca.length && ca[i] >= '0' && ca[i] <= '9') {
                    cur = 10 * cur + ca[i++] - '0';
                }

                if (!pos)
                    cur = -cur;

                res.add(new NestedInteger(cur));
            }

        }
        return res;
    }
}
