package com.epam.esm.dto.converter.impl;

import com.epam.esm.dto.UserDto;
import com.epam.esm.dto.converter.DtoConverter;
import com.epam.esm.entity.User;
import org.springframework.stereotype.Component;

/**
 * Class {@code UserDtoConverter} is implementation of interface {@link DtoConverter}
 * and intended to work with {@link User} and {@link UserDto} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class UserDtoConverter implements DtoConverter<User, UserDto> {

    @Override
    public User convertToEntity(UserDto dto) {
        User user = new User();

        user.setId(dto.getId());
        user.setName(dto.getName());

        return user;
    }

    @Override
    public UserDto convertToDto(User entity) {
        UserDto userDto = new UserDto();

        userDto.setId(entity.getId());
        userDto.setName(entity.getName());

        return userDto;
    }
}
