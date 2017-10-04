package com.presentation.java8.stream;

import com.presentation.java8.Annotations.Good;
import com.presentation.java8.Annotations.Ugly;
import com.presentation.java8.User;

import java.util.Collection;
import java.util.Objects;

import static java.util.Optional.ofNullable;

public class SameOldCodeStyleWithNewConstructs {
    @Ugly
    class NoMoreThanSameOldLoopWithIf {
        public void registerUsers(Collection<User> users) {
            users.stream().forEach(user ->
                    ofNullable(user).ifPresent(u -> {
                        //register user
                    })
            );
        }
    }

    @Good
    class NewStreamStyleWithMethodReference {
        public void registerUsers(Collection<User> users) {
            users.stream()
                    .filter(Objects::nonNull)
                    .forEach(this::registerUser);
        }

        private void registerUser(User user) {
            //register user
        }
    }
}
