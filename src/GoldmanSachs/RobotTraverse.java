package GoldmanSachs;

/*
There is robot who can traverse from one point to another given a path to traverse,
So the robot can only traverse in four direction UP, DOWN , RIGHT, LEFT represented by 'U' , 'D', 'R' ,'L' respectively.
and ignore all other command.
  so given a path and initial  co-ordinate you have to evaluate the destination co-ordinate.
 source path(0,0) -> string path given{Up Down Right Left LL ll dd} - > Targeted path(-2,0)

solution: https://www.geeksforgeeks.org/position-of-robot-after-given-movements/
Count number of up movements (U), down movements (D), left movements (L) and right movements (R) as countUp, countDown, countLeft and countRight respectively. Final x-coordinate will be
(countRight – countLeft) and y-coordinate will be (countUp – countDown).
 */
public class RobotTraverse {

    // function to to find final position of
    // robot after the complete movement
    static void finalPosition(String move) {

        int l = move.length();
        int countUp = 0, countDown = 0;
        int countLeft = 0, countRight = 0;

        // traverse the instruction string
        // 'move'
        for (int i = 0; i < l; i++) {

            // for each movement increment
            // its respective counter
            if (move.charAt(i) == 'U')
                countUp++;

            else if (move.charAt(i) == 'D')
                countDown++;

            else if (move.charAt(i) == 'L')
                countLeft++;

            else if (move.charAt(i) == 'R')
                countRight++;
        }

        // required final position of robot
        System.out.println("Final Position: ("
                + (countRight - countLeft) + ", "
                + (countUp - countDown) + ")");
    }

    // Driver program to test above
    public static void main(String[] args) {
        String move = "UDDLLRUUUDUURUDDUULLDRRRR";
        finalPosition(move);
    }
}
