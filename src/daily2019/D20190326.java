package daily2019;

import java.util.HashMap;
import java.util.Map;

/*
Write a function to flatten a nested dictionary. Namespace the keys with a period.

For example, given the following dictionary:

{
    "key": 3,
    "foo": {
        "a": 5,
        "bar": {
            "baz": 8
        }
    }
}
it should become:

{
    "key": 3,
    "foo.a": 5,
    "foo.bar.baz": 8
}
You can assume keys do not contain dots in them, i.e. no clobbering will occur.

@Stripe
@string
@json
@solved
@recursive
@easy
很简单的递归就可以了

@5min
 */
public class D20190326 {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", 3);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("a", 5);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("baz", 8);
        map1.put("bar", map2);
        map.put("foo", map1);

        Map<String, Integer> res = flatternMap(null, map);
        res.entrySet().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
    }

    public static Map<String, Integer> flatternMap(String pre, Map<String, Object> dic) {
        Map<String, Integer> res = new HashMap<>();
        for (Map.Entry<String, Object> entry : dic.entrySet()) {
            if (entry.getValue() instanceof Integer) {
                if (pre != null) {
                    res.put(pre + "." + entry.getKey(), (Integer) entry.getValue());
                } else {
                    res.put(entry.getKey(), (Integer) entry.getValue());
                }
            } else {
                // not int must map
                String p = pre;
                if (p != null) {
                    p = p + "." + entry.getKey();
                } else {
                    p = entry.getKey();
                }
                res.putAll(flatternMap(p, (Map<String, Object>) entry.getValue()));
            }
        }
        return res;
    }
}
