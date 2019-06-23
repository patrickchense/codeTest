package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpTest {


    public static void main(String[] args) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println("ip=" + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
