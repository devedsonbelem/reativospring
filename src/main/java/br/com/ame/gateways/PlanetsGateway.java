package br.com.ame.gateways;

import br.com.ame.domains.entity.Planets;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetsGateway {

    Mono<Planets> save(Planets planeta);
     Mono<Void> deleteByCode(String code);
     Flux<Planets> findAll();
     Mono<Planets> findByName(String name);
}
