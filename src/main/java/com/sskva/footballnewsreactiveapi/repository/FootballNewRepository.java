package com.sskva.footballnewsreactiveapi.repository;

import com.sskva.footballnewsreactiveapi.domain.FootballNew;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface FootballNewRepository extends ReactiveMongoRepository<FootballNew, String> {

    Flux<FootballNew> findAll();

    Flux<FootballNew> findByType(String s);
}
