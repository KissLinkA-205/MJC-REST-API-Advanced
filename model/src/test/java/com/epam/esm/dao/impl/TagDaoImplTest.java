package com.epam.esm.dao.impl;

import com.epam.esm.dao.TagDao;
import com.epam.esm.config.DaoConfig;
import com.epam.esm.entity.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DaoConfig.class)
class TagDaoImplTest {
    private final TagDao tagDao;

    private static final Tag TAG_1 = new Tag(1, "tagName1");
    private static final Tag TAG_2 = new Tag(2, "tagName3");
    private static final Tag TAG_3 = new Tag(3, "tagName5");
    private static final Tag TAG_4 = new Tag(4, "tagName4");
    private static final Tag TAG_5 = new Tag(5, "tagName2");

    private static final String SORT_PARAMETER = "DESC";
    private static final Pageable pageRequest = PageRequest.of(0, 5);

    @Autowired
    public TagDaoImplTest(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Test
    public void testFindAll() {
        List<Tag> actual = tagDao.findAll(pageRequest);
        List<Tag> expected = Arrays.asList(TAG_1, TAG_2, TAG_3, TAG_4, TAG_5);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindById() {
        Optional<Tag> actual = tagDao.findById(TAG_3.getId());
        Optional<Tag> expected = Optional.of(TAG_3);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindByName() {
        Optional<Tag> actual = tagDao.findByName(TAG_2.getName());
        Optional<Tag> expected = Optional.of(TAG_2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetWithFilters() {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("sortByName", SORT_PARAMETER);
        List<Tag> actual = tagDao.findWithFilters(parameters, pageRequest);
        List<Tag> expected = Arrays.asList(TAG_3, TAG_4, TAG_2, TAG_5, TAG_1);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindByMostPopularOfUser() {
        Optional<Tag> actual = tagDao.findByMostPopularOfUser(1);
        Optional<Tag> expected = Optional.of(TAG_2);

        assertEquals(expected, actual);
    }
}