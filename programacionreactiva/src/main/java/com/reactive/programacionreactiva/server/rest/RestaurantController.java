package com.reactive.programacionreactiva.server.rest;

import com.reactive.programacionreactiva.server.model.Restaurant;
import com.reactive.programacionreactiva.server.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(value = "/restaurants")
    public Flux<Restaurant> restaurants(@RequestParam String cuisine) {
        return restaurantService.restaurantsWithCuisine(cuisine);
    }
}
