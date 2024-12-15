package com.pbattistella.queryread.order.api;

import com.pbattistella.queryread.order.exception.OrderNotFoundException;
import com.pbattistella.queryread.order.model.OrderModelRead;
import com.pbattistella.queryread.order.repository.OrderRepositoryRead;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/order", produces = { MediaType.APPLICATION_JSON_VALUE })
public class OrderController {

    private OrderRepositoryRead orderRepositoryRead;

    @GetMapping
    @Operation(description = "Retorna a lista de pedidos", method = "GET")
    public Page<OrderModelRead> findAll(@PageableDefault(sort = {"orderDate"})  Pageable pageable) {
        return orderRepositoryRead.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "Retorna o pedido por id", method = "GET")
    public OrderModelRead findById(@PathVariable String id) {
        return orderRepositoryRead.findById(id)
            .orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado."));
    }

}
