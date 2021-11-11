package com.epam.esm.hateoas.impl;

import com.epam.esm.controller.UserController;
import com.epam.esm.dto.UserDto;
import com.epam.esm.hateoas.HateoasAdder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Class {@code UserHateoasAdder} is implementation of interface {@link HateoasAdder}
 * and intended to work with {@link UserDto} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class UserHateoasAdder implements HateoasAdder<UserDto> {
    private static final Class<UserController> CONTROLLER = UserController.class;

    @Override
    public void addLinks(UserDto userDto) {
        userDto.add(linkTo(methodOn(CONTROLLER).userById(userDto.getId())).withSelfRel());
    }
}
