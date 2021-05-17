package br.com.ame.controller;

import br.com.ame.domains.entity.Planets;
import br.com.ame.exceptions.PlanetsException;
import br.com.ame.gateways.PlanetsGatewayImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@RestController
@RequestMapping("api")
public class PlanetsController {


    private PlanetsGatewayImpl gateway;

    @Autowired
    public PlanetsController(final PlanetsGatewayImpl gateway) {
        this.gateway = gateway;
    }

    @PostMapping("/planets")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Planets> create(@RequestBody final Planets planeta){
        return gateway.save(planeta).doOnNext(planeta1 ->
                log.debug("Create new Planeta   - {}", planeta1 ));
    }

    @PutMapping("/planets")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Planets> update(@RequestBody final Mono<Planets> Planeta) {
        return Planeta.flatMap(p -> gateway.save(p)
                .doOnNext(cli -> log.info("Updating product - {}",  cli)));
    }

    @GetMapping("/planets/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Planets> findOne(@PathVariable final String name) {
        return gateway.findByName(name)
                .switchIfEmpty(Mono.error(new PlanetsException(name)))
                .doOnNext(p -> log.debug("Get product by code {}", name));
    }

    @DeleteMapping("/planets/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void> delete(@PathVariable final String name) {
        return gateway.deleteByCode(name);
    }



    @GetMapping(path ="/dev/planets", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<ServerResponse>  findAll() {
        Flux<Planets> planets = gateway.findAll();
       return ServerResponse.ok().contentType(APPLICATION_JSON).body(planets, Planets.class);
    }

    @GetMapping("/dev/planets/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Object> quantidade(@PathVariable final String name) {
        return gateway.findByName(name)
                .switchIfEmpty(Mono.error(new PlanetsException(name)))
                .map(x ->  x.getFilms().size() +" Films");
    }




}
