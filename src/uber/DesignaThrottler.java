package uber;

/*
Implement a throttler that executes an array of tasks. When the throttler is passed a number, only execute that number of the tasks and passes the other tasks into a queue.

This problem has a stackoverflow post from a year ago : https://stackoverflow.com/questions/49826332/simple-task-runner-in-javascript-with-waiting?rq=1

class Runner {
  constructor(concurrent) {
    this.taskQueue = []; //this should have "concurrent" number of tasks running at any given time

  }

  push(task) {
   //  pushes to the queue and then runs the whole queue
  }
          }
          The calling pattern would be:

          let runner = new Runner(3);
          runner.push(task1);
          runner.push(task2);
          runner.push(task3);
          runner.push(task4);
          While the post has a few implementations, I wonder if there is a cleaner way to do this.

 */
public class DesignaThrottler {
}
