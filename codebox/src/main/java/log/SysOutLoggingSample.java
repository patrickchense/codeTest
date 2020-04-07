package log;

import com.obsidiandynamics.zerolog.Zlg;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class SysOutLoggingSample {

    private static final Zlg zlg = Zlg.forDeclaringClass().get();

    public static void open(String address, int port, double timeoutSeconds) {
        zlg.i("Hello world");
        zlg.i("Pi is %.2f", z -> z.arg(Math.PI));
        zlg.i("Connecting to %s:%d [timeout: %.1f sec]", z -> z.arg(address).arg(port).arg(timeoutSeconds));

        try {
            openSocket(address, port, timeoutSeconds);
        } catch (IOException e) {
            zlg.w("Error connecting to %s:%d", z -> z.arg(address).arg(port).tag("I/O").threw(e));
        }
    }

    private static void openSocket(String address, int port, double timeoutSeconds) throws IOException {

    }

    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(5, 6, 7, 8);
        zlg.i("The list %s has %d elements", z -> z.arg(numbers).arg(numbers.size()).tag("list"));

        // FP format, supplier
        zlg.i("The list %s has %d elements", z -> z.arg(numbers).arg(numbers::size).tag("list"));

    }


}
