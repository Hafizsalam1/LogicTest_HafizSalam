import java.util.*;

public class AnagramChecker {
    public List<List<String>> AnagramChecker(String[] input) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> mapString = new HashMap<>();

        for (String str : input) {
            char[] chars = str.toCharArray();

            for (int i = 0; i < chars.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] < chars[minIndex]) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    char temp = chars[i];
                    chars[i] = chars[minIndex];
                    chars[minIndex] = temp;
                }
            }

            String sortedStr = new String(chars);

            if (!mapString.containsKey(sortedStr)) {
                mapString.put(sortedStr, new ArrayList<>());
            }
            mapString.get(sortedStr).add(str);
        }

        for (List<String> group : mapString.values()) {
            result.add(group);
        }

        return result;
    }
}