package com.presentation.java8.lampda;

import com.presentation.java8.Annotations.Good;
import com.presentation.java8.Annotations.Ugly;
import com.presentation.java8.User;
import com.presentation.java8.UserDto;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class AvoidLongLambdas {
    @Ugly
    class LongLambdaInPlace {
        public List<UserDto> convertToDto(List<User> users) {
            return users.stream()
                    .map(user -> {
                        UserDto dto = new UserDto();
                        dto.setId(user.getId());
                        dto.setName(user.getName());
                        //it happens to be much more fields and much more logic in terms of remapping these fields
                        return dto;
                    })
                    .collect(toList());
        }
    }

    @Good
    class MethodReferenceInsteadOfLambda {
        //particular toDto could be implemented as a separate class or as a lambda function
        private final Function<User, UserDto> toDto = this::convertToDto;

        public List<UserDto> convertToDto(List<User> users) {
            return users.stream()
                    .map(toDto)
                    .collect(toList());
        }

        private UserDto convertToDto(User user) {
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            return dto;
        }
    }
}