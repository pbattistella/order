package com.pbattistella.order.api;

import com.pbattistella.order.api.dto.CreateOrderDto;
import com.pbattistella.order.application.OrderApplicationService;
import com.pbattistella.order.application.command.CreateOrderCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(path = OrderController.PATH, produces = APPLICATION_JSON_VALUE)
public class OrderController {

    public static final String PATH = "/api/v1/order";

    private final OrderApplicationService orderApplicationService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(description = "Adicionar um novo pedido", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Não foi possível criar o pedido.") })
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDto dto) {

        var id = orderApplicationService.handle(CreateOrderDto.toCommand(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/").path(id).build().toUri();
        return ResponseEntity.created(uri).build();
    }
}
