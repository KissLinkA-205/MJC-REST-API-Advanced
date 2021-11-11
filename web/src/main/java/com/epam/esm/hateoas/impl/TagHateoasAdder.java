package com.epam.esm.hateoas.impl;

import com.epam.esm.controller.TagController;
import com.epam.esm.dto.TagDto;
import com.epam.esm.dto.converter.impl.TagDtoConverter;
import com.epam.esm.hateoas.HateoasAdder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Class {@code TagHateoasAdder} is implementation of interface {@link HateoasAdder}
 * and intended to work with {@link TagDto} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class TagHateoasAdder implements HateoasAdder<TagDto> {
    private static final Class<TagController> CONTROLLER = TagController.class;

    @Override
    public void addLinks(TagDto tagDto) {
        tagDto.add(linkTo(methodOn(CONTROLLER).tagById(tagDto.getId())).withSelfRel());
        tagDto.add(linkTo(methodOn(CONTROLLER).deleteTag(tagDto.getId())).withRel("delete"));
        tagDto.add(linkTo(methodOn(CONTROLLER).createTag(tagDto)).withRel("new"));
    }
}
