package br.com.ame.gateways;

import br.com.ame.domains.entity.Films;
import br.com.ame.domains.entity.Planets;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FilmsGateway {

     Mono<Films> findByTitle(String title);
     Mono<Films> save(Films films);
     Mono<?> deleteFilmsByTitle(String title);
     public Flux<Films> findAll();
}
