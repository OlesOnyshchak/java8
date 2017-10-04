package com.presentation.java8.optional;

import com.presentation.java8.Annotations.*;
import com.presentation.java8.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalForCollections {
    private static final String ADMIN_ROLE = "admin";

    @Ugly
    class TooVerbose {
        public User findAnyAdmin() {
            Optional<List<User>> users = findUsersByRole(ADMIN_ROLE);
            if (users.isPresent() && !users.get().isEmpty()) {
                return users.get().get(0);
            }
            throw new IllegalStateException("No admins found");
        }

        private Optional<List<User>> findUsersByRole(String role) {
            //real search in DB
            return Optional.empty();
        }
    }

    @Good
    class NiceAndClean {
        public User findAnyAdmin() {
            return findUsersByRole(ADMIN_ROLE).stream()
                    .findAny()
                    .orElseThrow(() -> new IllegalStateException("No admins found"));
        }

        private List<User> findUsersByRole(String role) {
            //real search in DB
            return Collections.emptyList();
        }
    }
}