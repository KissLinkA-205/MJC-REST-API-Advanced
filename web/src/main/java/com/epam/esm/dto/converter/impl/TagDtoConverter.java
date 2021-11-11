package com.epam.esm.dto.converter.impl;

import com.epam.esm.dto.TagDto;
import com.epam.esm.dto.converter.DtoConverter;
import com.epam.esm.entity.Tag;
import org.springframework.stereotype.Component;

/**
 * Class {@code TagDtoConverter} is implementation of interface {@link DtoConverter}
 * and intended to work with {@link Tag} and {@link TagDto} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class TagDtoConverter implements DtoConverter<Tag, TagDto> {

    @Override
    public Tag convertToEntity(TagDto dto) {
        Tag tag = new Tag();

        tag.setId(dto.getId());
        tag.setName(dto.getName());

        return tag;
    }

    @Override
    public TagDto convertToDto(Tag entity) {
        TagDto tagDto = new TagDto();

        tagDto.setId(entity.getId());
        tagDto.setName(entity.getName());

        return tagDto;
    }
}
