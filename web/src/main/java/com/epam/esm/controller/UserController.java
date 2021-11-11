package com.epam.esm.controller;

import com.epam.esm.dto.UserDto;
import com.epam.esm.dto.converter.DtoConverter;
import com.epam.esm.entity.User;
import com.epam.esm.hateoas.HateoasAdder;
import com.epam.esm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class {@code UserController} is an endpoint of the API which allows to perform operations on users.
 * Annotated by {@link RestController} with no parameters to provide an answer in application/json.
 * Annotated by {@link RequestMapping} with parameter value = "/users".
 * So that {@code UserController} is accessed by sending request to /users.
 *
 * @author Anzhalika Dziarkach
 * @since 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    private final DtoConverter<User, UserDto> userDtoConverter;
    private final HateoasAdder<UserDto> hateoasAdder;

    @Autowired
    public UserController(UserService userService, DtoConverter<User, UserDto> userDtoConverter,
                          HateoasAdder<UserDto> hateoasAdder) {
        this.userService = userService;
        this.userDtoConverter = userDtoConverter;
        this.hateoasAdder = hateoasAdder;
    }

    /**
     * Method for getting all users from data source.
     *
     * @param page the number of page for pagination
     * @param size the size of page for pagination
     * @return List of found users with hateoas
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> allUsers(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                  @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
        List<User> users = userService.getAll(page, size);

        return users.stream()
                .map(userDtoConverter::convertToDto)
                .peek(hateoasAdder::addLinks)
                .collect(Collectors.toList());
    }

    /**
     * Method for getting user by ID.
     *
     * @param id ID of user to get
     * @return Found user entity with hateoas
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto userById(@PathVariable long id) {
        User user = userService.getById(id);

        UserDto userDto = userDtoConverter.convertToDto(user);
        hateoasAdder.addLinks(userDto);
        return userDto;
    }
}
