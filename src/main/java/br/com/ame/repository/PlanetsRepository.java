package br.com.ame.repository;

import br.com.ame.domains.entity.Planets;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public  interface PlanetsRepository extends ReactiveCrudRepository<Planets, String> {
        Mono<Planets> findByName(String name);
}
