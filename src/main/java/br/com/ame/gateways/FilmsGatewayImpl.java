package br.com.ame.gateways;

import br.com.ame.domains.entity.Films;
import br.com.ame.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;


@Component
public class FilmsGatewayImpl implements FilmsGateway {

    private FilmsRepository repository;

    @Autowired
    public FilmsGatewayImpl(final FilmsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Films> findByTitle(String title) {
         return repository.findByTitle(title);
    }


    @Override
    public Mono<Films> save(Films films) {
        return  repository.save(films);
    }

    @Override
    public Mono<Films> deleteFilmsByTitle(String title) {
          return    repository.findByTitle(title);

    }
    @Override
    public Flux<Films> findAll() {
        return    repository.findAll();

    }

}
