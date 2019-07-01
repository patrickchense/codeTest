import util.MurmurHash;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.SortedMap;
import java.util.TreeMap;

public class RedisKeyTest {

    static TreeMap<Long, String> nodes;
    static MurmurHash hash = new MurmurHash();

    public static void main(String[] args) throws IOException {

        nodes = new TreeMap<>();
        for (int i = 0; i < 32; i++) {
            for (int n = 0; n < 160; n++) {
                nodes.put(hash.hash("SHARD-" + i + "-NODE-" + n), "SHARD-" + i + "-NODE-" + n);
            }
        }
        System.out.println("nodes=" + nodes);
        System.out.println("--------------------------------");
        Files.lines(Paths.get("6426_rid.txt")).forEach(
                l ->  {
                    long h = hash.hash(l.trim().getBytes(StandardCharsets.UTF_8));
//                    System.out.println(l + ",hash=" + h);
                    System.out.println("node=" + getShardInfo(l.trim().getBytes(StandardCharsets.UTF_8)));
                }
        );
    }

    public static String getShardInfo(byte[] key) {
        SortedMap<Long, String> tail = nodes.tailMap(hash.hash(key));
        if (tail.isEmpty()) {
            return nodes.get(nodes.firstKey());
        }
        return tail.get(tail.firstKey());
    }
}
