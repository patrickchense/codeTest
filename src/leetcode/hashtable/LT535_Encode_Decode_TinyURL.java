package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
https://leetcode.com/problems/encode-and-decode-tinyurl/

@medium
@hashmap
@random
@answered
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.


关键在于理解，这里随机算法使用，然后随机的字符来自 a-z, A-Z, 0-9

 */
public class LT535_Encode_Decode_TinyURL {
    public Map<String, String> map;
    StringBuilder sb;
    public LT535_Encode_Decode_TinyURL(){
        map = new HashMap<>();
        sb = new StringBuilder();
        for (char ch = 'a' ; ch <= 'z'; ch++){
            sb.append(ch);
        }
        for (char c = 'A'; c <= 'Z'; c++){
            sb.append(c);
        }
        for (int i = 0; i < 10; i++){
            sb.append(i+"");
        }
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (map.containsKey(longUrl)){
            return map.get(longUrl);
        }
        Random rand = new Random();
        String r = sb.toString();
        StringBuilder ran = new StringBuilder();
        for (int i = 0; i < 7; i++){
            int index = (int) (r.length() * Math.random());
            ran.append(sb.charAt(index));
        }
        String url = "http://tinyurl.com/" + ran.toString();
        map.put(longUrl, url);
        return url;
    }
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        for (String key : map.keySet()){
            if (map.get(key).equals(shortUrl)){
                return key;
            }
        }
        return "err";

    }
}
