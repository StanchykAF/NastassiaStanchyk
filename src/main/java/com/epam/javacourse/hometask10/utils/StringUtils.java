package com.epam.javacourse.hometask10.utils;

import java.util.List;
import java.util.StringJoiner;

public class StringUtils {
    public static String joinerForInQuery(List<String> list) {
        StringJoiner joiner = new StringJoiner(", ", "(", ")");
        for (String o : list) {
            joiner.add(o);
        }
        return joiner.toString();
    }
}
