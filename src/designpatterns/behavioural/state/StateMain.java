package designpatterns.behavioural.state;

import java.io.PrintWriter;
import java.util.Date;

/*
https://github.com/gkatzioura/DesignPatterns/tree/master/src/main/java/com/gkatzioura/design/behavioural/state
 */
public class StateMain {
    public static void main(String[] args){
        StateUIContext stateUIContext = new StateUIContext();

        try(PrintWriter printWriter = new PrintWriter(System.out)) {
            stateUIContext.setGreetingState(new AnonymousGreetingState());
            stateUIContext.create(printWriter);
            printWriter.write("\n");
            stateUIContext.setGreetingState(new LoggedInGreetingState("haha1"));
            stateUIContext.create(printWriter);
            printWriter.write("\n");
            stateUIContext.setGreetingState(new AdminGreetingState("hehe1", new Date()));
            stateUIContext.create(printWriter);
            printWriter.write("\n");
        }
    }
}

