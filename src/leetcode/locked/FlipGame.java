package leetcode.locked;

import java.util.ArrayList;
import java.util.List;

/*
leetcode 293 Flip Game
https://blog.csdn.net/qq508618087/article/details/50855968

You are playing the following Flip Game with your friend: Given a string that contains only these two characters: 
+ and -, you and your friend take turns to flip two consecutive "++" into "--".
The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].


 */
public class FlipGame {

    public List<String> filpGame(String s) {
        List<String> res = new ArrayList<>();
        char[] cs = s.toCharArray();
        int len = s.length();
        for(int i = 0; i < len-1; i++)
            if(cs[i]=='+' && cs[i+1]=='+')
                res.add(s.substring(0,i)+"--"+s.substring(i+2));
        return res;
    }
}
