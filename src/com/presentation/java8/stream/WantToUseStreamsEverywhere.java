package com.presentation.java8.stream;

import com.presentation.java8.Annotations.Good;
import com.presentation.java8.Annotations.Ugly;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class WantToUseStreamsEverywhere {
    @Ugly
    class UseStreamToBuildMap {
        public Map<String, Object> getJpaProperties() {
            return Collections.unmodifiableMap(
                    Stream.of(
                            new AbstractMap.SimpleEntry<>("hibernate.show_sql", "true"),
                            new AbstractMap.SimpleEntry<>("hibernate.format_sql", "true")
                    ).collect(toMap(Map.Entry::getKey, Map.Entry::getValue))
            );
        }
    }

    @Good
    class UseOldPlainMap {
        public Map<String, Object> getJpaProperties() {
            Map<String, Object> properties = new HashMap<>();
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");
            return Collections.unmodifiableMap(properties);
        }
    }
}
