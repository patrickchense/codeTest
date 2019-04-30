package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/find-duplicate-file-in-system/

@hashmap

@medium

@solved
@10min

 */
public class LT609_Duplicate_File_Content {

    // O(n∗x). n strings of average length x is parsed
    // O(n∗x). map and res size grows upto n∗x.
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentFiles =new HashMap<>();
        for (String p : paths) {
            String[] ps = p.split(" ");
            for (int i = 1; i < ps.length; i++) {
                String file = ps[i];
                String fileName = file.substring(0, file.indexOf("("));
                String content = file.substring(file.indexOf("(") + 1, file.length() -1);
                String newPath = ps[0] + "/" + fileName;
                if (contentFiles.containsKey(content)) {
                    contentFiles.get(content).add(newPath);
                } else {
                    List<String> newPaths = new ArrayList<>();
                    newPaths.add(newPath);
                    contentFiles.put(content, newPaths);
                }
            }
        }
        return contentFiles.values().stream().filter(l -> l.size() > 1).collect(Collectors.toList());
    }
}
