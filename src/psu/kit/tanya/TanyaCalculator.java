package psu.kit.tanya;

import java.util.HashMap;

public class TanyaCalculator {

    private HashMap<Character, Integer> map;

    private void decreaseValue(char key) {
        map.put(key, map.get(key) - 1);
    }

    private void increaseValue(char key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    private Integer getValue(char key) {
        return map.getOrDefault(key, 0);
    }

    public TanyaReaction calculate(String s, String t) {
        map = new HashMap<>();

        int yayCount = 0;
        int whoopsCount = 0;

        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            increaseValue(ch);
        }

        StringBuilder text = new StringBuilder(s);
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (getValue(ch) > 0) {
                decreaseValue(ch);
                text.setCharAt(i, '\0');
                ++yayCount;
            }
        }

        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            ch = Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
            if (getValue(ch) > 0) {
                decreaseValue(ch);
                ++whoopsCount;
            }
        }
        return new TanyaReaction(yayCount, whoopsCount);
    }
}
