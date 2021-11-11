package com.epam.esm.dto.converter.impl;

import com.epam.esm.dto.OrderDto;
import com.epam.esm.dto.converter.DtoConverter;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Order;
import com.epam.esm.entity.User;
import org.springframework.stereotype.Component;

/**
 * Class {@code OrderDtoConverter} is implementation of interface {@link DtoConverter}
 * and intended to work with {@link Order} and {@link OrderDto} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class OrderDtoConverter implements DtoConverter<Order, OrderDto> {

    @Override
    public Order convertToEntity(OrderDto dto) {
        Order order = new Order();

        order.setId(dto.getId());
        order.setPrice(dto.getPrice());
        order.setPurchaseTime(dto.getPurchaseTime());

        User user = new User();
        user.setId(dto.getUserId());
        order.setUser(user);

        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(dto.getGiftCertificateId());
        order.setGiftCertificate(giftCertificate);

        return order;
    }

    @Override
    public OrderDto convertToDto(Order entity) {
        OrderDto orderDto = new OrderDto();

        orderDto.setId(entity.getId());
        orderDto.setPrice(entity.getPrice());
        orderDto.setPurchaseTime(entity.getPurchaseTime());
        orderDto.setUserId(entity.getUser().getId());
        orderDto.setGiftCertificateId(entity.getGiftCertificate().getId());

        return orderDto;
    }
}
