package com.epam.esm.controller;

import com.epam.esm.dto.GiftCertificateDto;
import com.epam.esm.dto.converter.DtoConverter;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.hateoas.HateoasAdder;
import com.epam.esm.service.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class {@code GiftCertificateController} is an endpoint of the API
 * which allows to perform CRUD operations on gift certificates.
 * Annotated by {@link RestController} with no parameters to provide an answer in application/json.
 * Annotated by {@link RequestMapping} with parameter value = "/certificates".
 * So that {@code GiftCertificateController} is accessed by sending request to /certificates.
 *
 * @author Anzhalika Dziarkach
 * @since 1.0
 */
@RestController
@RequestMapping("/certificates")
public class GiftCertificateController {
    private final GiftCertificateService giftCertificateService;

    private final DtoConverter<GiftCertificate, GiftCertificateDto> giftCertificateDtoConverter;
    private final HateoasAdder<GiftCertificateDto> hateoasAdder;

    @Autowired
    public GiftCertificateController(GiftCertificateService giftCertificateService, HateoasAdder<GiftCertificateDto> hateoasAdder,
                                     DtoConverter<GiftCertificate, GiftCertificateDto> giftCertificateDtoConverter) {
        this.giftCertificateService = giftCertificateService;
        this.hateoasAdder = hateoasAdder;
        this.giftCertificateDtoConverter = giftCertificateDtoConverter;
    }

    /**
     * Method for getting gift certificate by ID.
     *
     * @param id ID of gift certificate to get
     * @return Found gift certificate entity with hateoas
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GiftCertificateDto giftCertificateById(@PathVariable long id) {
        GiftCertificate giftCertificate = giftCertificateService.getById(id);

        GiftCertificateDto giftCertificateDto = giftCertificateDtoConverter.convertToDto(giftCertificate);
        hateoasAdder.addLinks(giftCertificateDto);
        return giftCertificateDto;
    }

    /**
     * Method for removing gift certificate by ID.
     *
     * @param id ID of gift certificate to remove
     * @return NO_CONTENT HttpStatus
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteGiftCertificate(@PathVariable long id) {
        giftCertificateService.removeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Method for saving new gift certificate.
     *
     * @param giftCertificate gift certificate for saving
     * @return created gift certificate with hateoas
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GiftCertificateDto createGiftCertificate(@RequestBody GiftCertificateDto giftCertificate) {
        GiftCertificate addedGiftCertificate = giftCertificateService.insert(
                giftCertificateDtoConverter.convertToEntity(giftCertificate));

        GiftCertificateDto giftCertificateDto = giftCertificateDtoConverter.convertToDto(addedGiftCertificate);
        hateoasAdder.addLinks(giftCertificateDto);
        return giftCertificateDto;
    }

    /**
     * Method for updating tags from the gift certificate.
     *
     * @param giftCertificate gift certificate entity, which include information to update
     * @param id              ID of gift certificate
     * @return updated gift certificate with hateoas
     */
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GiftCertificateDto updateGiftCertificate(@PathVariable long id,
                                                    @RequestBody GiftCertificateDto giftCertificate) {
        GiftCertificate updatedGiftCertificate = giftCertificateService.update(id,
                giftCertificateDtoConverter.convertToEntity(giftCertificate));

        GiftCertificateDto giftCertificateDto = giftCertificateDtoConverter.convertToDto(updatedGiftCertificate);
        hateoasAdder.addLinks(giftCertificateDto);
        return giftCertificateDto;
    }

    /**
     * Method for getting list of gift certificates from data source by special filter.
     * If there are no filters, then it returns all gift certificates.
     *
     * @param page             the number of page for pagination
     * @param size             the size of page for pagination
     * @param allRequestParams request parameters, which include the information needed for the search
     * @return List of found gift certificates with hateoas
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GiftCertificateDto> giftCertificatesByParameter(@RequestParam MultiValueMap<String, String> allRequestParams,
                                                                @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                                @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
        List<GiftCertificate> giftCertificates = giftCertificateService.doFilter(allRequestParams, page, size);

        return giftCertificates.stream()
                .map(giftCertificateDtoConverter::convertToDto)
                .peek(hateoasAdder::addLinks)
                .collect(Collectors.toList());
    }
}
