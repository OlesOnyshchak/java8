package com.presentation.java8.lampda.collections;

import com.presentation.java8.Annotations.Good;
import com.presentation.java8.Annotations.Ugly;
import com.presentation.java8.User;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class MapIterating {
    @Ugly
    class UsingOldGoodEntrySet {
        public Map<String, String> getUserNames(Map<String, User> users) {
            Map<String, String> userNames = new HashMap<>();
            users.entrySet().forEach(user ->
                    userNames.put(user.getKey(), user.getValue().getName()));
            return userNames;
        }
    }

    @Good
    class UsingMapForEach {
        public Map<String, String> getUserNames(Map<String, User> users) {
            Map<String, String> userNames = new HashMap<>();
            users.forEach((key, value) -> userNames.put(key, value.getName()));
            return userNames;
        }
    }

    @Good
    class UsingMapTransform {
        public Map<String, String> getUserNames(Map<String, User> users) {
            return users.entrySet().stream()
                    .collect(toMap(Map.Entry::getKey,
                            entry -> entry.getValue().getName()));
        }
    }
}