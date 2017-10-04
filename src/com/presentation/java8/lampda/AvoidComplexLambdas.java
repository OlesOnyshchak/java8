package com.presentation.java8.lampda;

import com.presentation.java8.Annotations.Good;
import com.presentation.java8.Annotations.Ugly;
import com.presentation.java8.Permission;
import com.presentation.java8.Role;
import com.presentation.java8.User;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toSet;

public class AvoidComplexLambdas {
    private final Set<User> users = new HashSet<>();

    @Ugly
    class UsingComplexLambdaInPlace {
        public Set<User> findEditors() {
            return users.stream()
                    .filter(u -> u.getRoles().stream()
                     .anyMatch(r -> r.getPermissions()
                                    .contains(Permission.EDIT)))
                    .collect(toSet());
        }
    }

    @Good
    class ComplexityExtractedToMethodReference {
        public Set<User> checkPermission(Permission permission) {
            return users.stream()
                    //.filter(this::hasEditPermission)
                    .filter(hasPermission(Permission.EDIT))
                    .collect(toSet());
        }

        private Predicate<User> hasPermission(Permission permission) {
            return user -> user.getRoles().stream()
                    .map(Role::getPermissions)
                    .anyMatch(permissions -> permissions.contains(permission));
        }

        private boolean hasEditPermission(User user) {
            return hasPermission(Permission.EDIT).test(user);
        }
    }
}