package br.com.ame.gateways;

import br.com.ame.domains.entity.Planets;
import br.com.ame.repository.PlanetsRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;


@Component
public class PlanetsGatewayImpl implements PlanetsGateway {

    private PlanetsRepository repository;

    @Autowired
    public PlanetsGatewayImpl(final PlanetsRepository repository) {

        this.repository = repository;
    }



    @Override
    public Mono<Planets> save(Planets planeta) {

        return  repository.save(planeta);
    }





    @Override
    public Mono<Void> deleteByCode(final String code) {

            return repository.deleteById(code);
    }


    @Override
    public Flux<Planets> findAll() {

          return repository.findAll();
    }

    @Override
   public Mono<Planets> findByName(String name){
        return repository.findByName(name);
    }
}
