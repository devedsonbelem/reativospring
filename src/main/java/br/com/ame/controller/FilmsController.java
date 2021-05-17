package br.com.ame.controller;

import br.com.ame.domains.entity.Films;
import br.com.ame.domains.entity.Planets;
import br.com.ame.exceptions.FilmsException;
import br.com.ame.gateways.FilmsGatewayImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@RestController
@RequestMapping("rest")
public class FilmsController {

    private FilmsGatewayImpl gatewayFilm;

    @Autowired
    public FilmsController(final FilmsGatewayImpl gatewayFilm) {

        this.gatewayFilm = gatewayFilm;
    }


    @GetMapping(path ="/films", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public  Flux<Films>  findAll() {
        return gatewayFilm.findAll();
    }

    @GetMapping("/films/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Films> findOne(@PathVariable final String title) {
        return gatewayFilm.findByTitle(title)
                .switchIfEmpty(Mono.error(new FilmsException(title)))
                .doOnNext(p -> log.debug("Get product by code {}", title));
    }

    @PostMapping("/films")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Films> create(@RequestBody final Films films){
        return gatewayFilm.save(films).doOnNext(films1 ->
                log.debug("Create new Planeta   - {}",  films1 ));
    }



    @DeleteMapping("/films/{title}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  Mono<Films> delete(@PathVariable final String title) {
         return gatewayFilm.deleteFilmsByTitle(title);
    }



}
