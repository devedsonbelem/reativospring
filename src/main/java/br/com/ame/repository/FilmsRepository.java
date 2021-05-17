package br.com.ame.repository;

import br.com.ame.domains.entity.Films;
import br.com.ame.domains.entity.Planets;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FilmsRepository extends ReactiveCrudRepository<Films, String> {
    Mono<Films> findByTitle(String title);
    Mono<Films>  deleteFilmsByTitle(String title);
}
