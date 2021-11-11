package com.epam.esm.controller;

import com.epam.esm.dto.OrderDto;
import com.epam.esm.dto.converter.DtoConverter;
import com.epam.esm.entity.Order;
import com.epam.esm.hateoas.HateoasAdder;
import com.epam.esm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Class {@code OrderController} is an endpoint of the API which allows to perform operations on orders.
 * Annotated by {@link RestController} with no parameters to provide an answer in application/json.
 * Annotated by {@link RequestMapping} with parameter value = "/orders".
 * So that {@code OrderController} is accessed by sending request to /orders.
 *
 * @author Anzhalika Dziarkach
 * @since 1.0
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    private final DtoConverter<Order, OrderDto> orderDtoConverter;
    private final HateoasAdder<OrderDto> hateoasAdder;

    @Autowired
    public OrderController(OrderService orderService, DtoConverter<Order, OrderDto> orderDtoConverter,
                           HateoasAdder<OrderDto> hateoasAdder) {
        this.orderService = orderService;
        this.orderDtoConverter = orderDtoConverter;
        this.hateoasAdder = hateoasAdder;
    }

    /**
     * Method for getting order by ID.
     *
     * @param id ID of order to get
     * @return Found order entity with hateoas
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto orderById(@PathVariable("id") long id) {
        Order order = orderService.getById(id);

        OrderDto orderDto = orderDtoConverter.convertToDto(order);
        hateoasAdder.addLinks(orderDto);
        return orderDto;
    }

    /**
     * Method for saving new order.
     *
     * @param order order for saving
     * @return created order with hateoas
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody OrderDto order) {
        Order addedOrder = orderService.insert(orderDtoConverter.convertToEntity(order));

        OrderDto orderDto = orderDtoConverter.convertToDto(addedOrder);
        hateoasAdder.addLinks(orderDto);
        return orderDto;
    }

    /**
     * Method for getting orders by user ID.
     *
     * @param userId ID of user
     * @param page   the number of page for pagination
     * @param size   the size of page for pagination
     * @return Found list of orders with hateoas
     */
    @GetMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> ordersByUserId(@PathVariable long userId,
                                         @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                         @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
        List<Order> orders = orderService.getOrdersByUserId(userId, page, size);

        return orders.stream()
                .map(orderDtoConverter::convertToDto)
                .peek(hateoasAdder::addLinks)
                .collect(Collectors.toList());
    }
}
